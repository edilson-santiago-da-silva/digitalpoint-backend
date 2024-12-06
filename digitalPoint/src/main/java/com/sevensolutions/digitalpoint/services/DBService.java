package com.sevensolutions.digitalpoint.services;

import com.sevensolutions.digitalpoint.domain.Point;
import com.sevensolutions.digitalpoint.domain.User;
import com.sevensolutions.digitalpoint.domain.enums.Profile;
import com.sevensolutions.digitalpoint.repositores.PointRepository;
import com.sevensolutions.digitalpoint.repositores.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;

@Service
public class DBService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PointRepository pointRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void instanceDB() throws Exception {
        User user1 = new User(null, "Bianca Santos",encoder.encode("3427"));
        user1.addProfile(Profile.ADMIN);
        User user2 = new User(null, "Gabriel Santana",encoder.encode("3427"));
        User user3 = new User(null, "Lucas Simões",encoder.encode("3427"));

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date workDay = dateFormat.parse("01/10/2024");

        Point point1 = new Point(null, user1.getName(), workDay, LocalTime.parse("08:00"), LocalTime.parse("10:00"), LocalTime.parse("12:00"), LocalTime.parse("15:00"), user1);
        Point point2 = new Point(null, user2.getName(), workDay, LocalTime.parse("08:00"), LocalTime.parse("10:00"), LocalTime.parse("12:00"), LocalTime.parse("15:00"), user2);
        Point point3 = new Point(null, user3.getName(), workDay, LocalTime.parse("08:00"), LocalTime.parse("10:00"), LocalTime.parse("12:00"), LocalTime.parse("15:00"), user3);

        userRepository.saveAll(Arrays.asList(user1));
        userRepository.saveAll(Arrays.asList(user2));
        userRepository.saveAll(Arrays.asList(user3));

        pointRepository.saveAll(Arrays.asList(point1));
        pointRepository.saveAll(Arrays.asList(point2));
        pointRepository.saveAll(Arrays.asList(point3));
    }
}
