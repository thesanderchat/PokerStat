package com.example.demo.tournament;

import com.example.demo.player.Player;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tournament")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tournament{
    @Id
    @SequenceGenerator(
            name = "group_sequence",
            sequenceName = "group_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "group_sequence"
    )
    private Long id;
    @NotEmpty(message = "Name may not be empty")
    @Column(nullable = false)
    private String name;
    @NotNull(message = "Date of Start may not be null")
    @Column(nullable = false)
    private LocalDate dateOfStart;
    @NotNull(message = "Buy-in may not be null")
    @Column(nullable = false)
    private Long buyIn;
    @Builder.Default
    @ManyToMany(mappedBy = "tournamentList", fetch = FetchType.EAGER)
    private List<Player> playerList = new ArrayList<>();
}
