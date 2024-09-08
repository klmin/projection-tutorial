package com.projectiontutorial.team.projection;

import java.util.List;

public record TeamRecordProjection2(
    Long teamId,
    String teamName,
    Integer teamNum,
    List<Long> membersMemberId,
    List<String> membersName,
    List<Integer> membersAge

) {
}
