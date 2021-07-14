package com.fpl.fplmaster.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Data
public class SeasonInfo {
    private String season_name;
    private int total_points;
    private long rank;
}
