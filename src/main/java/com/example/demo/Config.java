package com.example.demo;

import com.example.demo.player.Player;
import com.example.demo.player.PlayerRepository;
import com.example.demo.tournament.Tournament;
import com.example.demo.tournament.TournamentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class Config {

    @Bean
    CommandLineRunner commandLineRunner(PlayerRepository playerRepository, TournamentRepository tournamentRepository) {
        return args -> {
            Player player1 = Player.builder().name("Vladislav").email("pishenkovladyslav@gmail.com").build();
            Player player2 = Player.builder().name("Oleksandr").email("sasha.dzuyniak@gmail.com").build();
            playerRepository.saveAll(List.of(player1,player2));
            Tournament tournament1 = Tournament.builder().name("Texas1").buyIn(5L).dateOfStart(LocalDate.of(2022, Month.JUNE, 5)).build();
            Tournament tournament2 = Tournament.builder().name("Dallas1").buyIn(7L).dateOfStart(LocalDate.of(2022, Month.JUNE, 6)).build();
            tournamentRepository.saveAll(List.of(tournament1,tournament2));
        };
    }
}
