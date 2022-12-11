package main;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FootballClub {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private int coast;
    private int balance;
    private int rating;
}
