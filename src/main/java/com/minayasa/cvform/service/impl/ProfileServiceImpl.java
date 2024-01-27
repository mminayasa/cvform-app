package com.minayasa.cvform.service.impl;

import com.minayasa.cvform.dto.ProfileDto;
import com.minayasa.cvform.dto.ProfileResponse;
import com.minayasa.cvform.entity.Address;
import com.minayasa.cvform.entity.User;
import com.minayasa.cvform.exception.CvApiException;
import com.minayasa.cvform.exception.ResourceNotFoundException;
import com.minayasa.cvform.repository.AddressRepository;
import com.minayasa.cvform.repository.UserRepository;
import com.minayasa.cvform.service.ProfileService;
import com.minayasa.cvform.util.CurrentUser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private UserRepository userRepository;
    private CurrentUser currentUser;

    @Override
    @Transactional
    public User addProfile(ProfileDto profileDto) {
        User user = currentUser.getCurrentUser();
        try {
            if(Boolean.TRUE.equals(userRepository.existsByEmail(profileDto.getEmail()))){
                throw new CvApiException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
            }
            user.setEmail(profileDto.getEmail());
            user.setFirstName(profileDto.getFirstName());
            user.setLastName(profileDto.getLastName());
            user.setPhone(profileDto.getPhone());
            user.setWantedJobTitle(profileDto.getWantedJobTitle());

            Address address = Address.builder()
                    .country(profileDto.getCountry())
                    .city(profileDto.getCity())
                    .address(profileDto.getAddress())
                    .postalCode(profileDto.getPostalCode())
                    .drivingLicense(profileDto.getDrivingLicense())
                    .nationality(profileDto.getNationality())
                    .placeOfBirth(profileDto.getPlaceOfBirth())
                    .dateOfBirth(profileDto.getDateOfBirth())
                    .build();
            user.setAddress(address);
            address.setUser(user);

            //            addressRepository.save(address);
            return userRepository.save(user);
        } catch (Exception exception) {
            throw new CvApiException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }

    }

    @Override
    public ProfileResponse getProfile() {
        User user = currentUser.getCurrentUser();
        return ProfileResponse.builder()
                .profileCode(user.getId())
                .wantedJobTitle(user.getWantedJobTitle())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .country(user.getAddress().getCountry())
                .city(user.getAddress().getCity())
                .address(user.getAddress().getAddress())
                .postalCode(user.getAddress().getPostalCode())
                .drivingLicence(user.getAddress().getDrivingLicense())
                .nationality(user.getAddress().getNationality())
                .placeOfBird(user.getAddress().getPlaceOfBirth())
                .dateOfBirth(user.getAddress().getDateOfBirth())
                .photoUrl(null)
                .build();
    }

    @Override
    @Transactional
    public User updateProfile(ProfileDto profileDto) {
        User user = currentUser.getCurrentUser();
        Address address = user.getAddress();
        user.setWantedJobTitle(profileDto.getWantedJobTitle());
        user.setFirstName(profileDto.getFirstName());
        user.setLastName(profileDto.getLastName());
        user.setEmail(profileDto.getEmail());
        user.setPhone(profileDto.getPhone());

        address.setCountry(profileDto.getCountry());
        address.setCity(profileDto.getCity());
        address.setAddress(profileDto.getAddress());
        address.setPostalCode(profileDto.getPostalCode());
        address.setDrivingLicense(profileDto.getDrivingLicense());
        address.setNationality(profileDto.getNationality());
        address.setPlaceOfBirth(profileDto.getPlaceOfBirth());
        address.setDateOfBirth(profileDto.getDateOfBirth());

        user.setAddress(address);

        return userRepository.save(user);
    }
}
