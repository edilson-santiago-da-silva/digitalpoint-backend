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
        User user1 = new User(null, "Bianca Santos", encoder.encode("3427"));
        user1.addProfile(Profile.ADMIN);

        LocalTime entry = LocalTime.parse("10:00");
        LocalTime entryLaunch = LocalTime.parse("12:00");
        LocalTime exitLaunch = LocalTime.parse("13:00");
        LocalTime exit = LocalTime.parse("18:40");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date workDay = dateFormat.parse("01/10/2024");

        Point tempPoint = new Point();
        long minExtra = tempPoint.getExtraHour(entry, exitLaunch, entryLaunch, exit);

        Point point1 = new Point(null, user1.getName(), workDay, entry, entryLaunch, exitLaunch, exit, minExtra, user1);

        userRepository.saveAll(Arrays.asList(user1));

        pointRepository.saveAll(Arrays.asList(point1));
    }
}
