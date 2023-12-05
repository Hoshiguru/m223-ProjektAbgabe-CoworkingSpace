package ch.zli.m223.service;

import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.model.Booking;
import ch.zli.m223.model.Credential;
import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.runtime.StartupEvent;

@IfBuildProfile("dev")
@ApplicationScoped
public class TestDataService {

    @Inject
    EntityManager entityManager;

    @Transactional
    void generatedTestData(@Observes StartupEvent event){
        //Credential
        var adminCred = new Credential();
        adminCred.setEmail("lennard.lee@coworking.com");
        adminCred.setPassword("SuperSecurePassword123");

        var memberCred = new Credential();
        memberCred.setEmail("susanne.schmidt@coworking.com");
        memberCred.setPassword("passwrod123");
        
        //ApplicationUsers
        var admin = new ApplicationUser();
        admin.setEmail(adminCred.getEmail());
        admin.setPassword(adminCred.getPassword());
        admin.setFirstName("Lennard");
        admin.setLastName("Lee");
        admin.setRole("Admin");

        var member = new ApplicationUser();
        member.setEmail(memberCred.getEmail());
        member.setPassword(memberCred.getPassword());
        member.setFirstName("Susanne");
        member.setLastName("Schmidt");
        member.setRole("Member");

        //Booking
        var adminBooking = new Booking();
        adminBooking.setBookingTime(LocalDateTime.parse("2023-08-01T08:00:00"));
        adminBooking.setEndTime(LocalDateTime.parse("2023-08-01T16:00:00"));
        adminBooking.setApproved(true);
        adminBooking.setApplicationUser(admin);

        var memberBooking1 = new Booking();
        memberBooking1.setBookingTime(LocalDateTime.parse("2023-08-02T08:00:00"));
        memberBooking1.setEndTime(LocalDateTime.parse("2023-08-02T16:00:00"));
        memberBooking1.setApproved(true);
        memberBooking1.setApplicationUser(member);

        var memberBooking2 = new Booking();
        memberBooking2.setBookingTime(LocalDateTime.parse("2023-08-03T08:00:00"));
        memberBooking2.setEndTime(LocalDateTime.parse("2023-08-03T16:00:00"));
        memberBooking2.setApproved(false);
        memberBooking2.setApplicationUser(member);

        //JWT
        String JWT = "";
    }
}
