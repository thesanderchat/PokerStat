package com.example.demo.player;

import com.example.demo.tournament.Tournament;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "player")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    @NonNull
    @Column(nullable = false)
    @NotEmpty(message = "Name may not be empty")
    private String name;
    @NonNull
    @Column(nullable = false)
    @NotEmpty(message = "Email may not be empty")
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "player_touranment", joinColumns = @JoinColumn(name = "player_id"), inverseJoinColumns = @JoinColumn(name = "tournament_id"))
    private List<Tournament> tournamentList;
}
