package com.fpl.fplmaster.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class ManagerHistory {
    List<SeasonInfo> current;
    List<SeasonInfo> past;
    List<SeasonInfo> chips;
}
