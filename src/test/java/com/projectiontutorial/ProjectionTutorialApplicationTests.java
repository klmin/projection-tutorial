package com.projectiontutorial;

import com.projectiontutorial.member.entity.Member;
import com.projectiontutorial.member.projection.MemberClassProjection;
import com.projectiontutorial.member.projection.MemberInterfaceProjection;
import com.projectiontutorial.member.projection.MemberRecordProjection;
import com.projectiontutorial.member.repository.MemberRepository;
import com.projectiontutorial.team.entity.Team;
import com.projectiontutorial.team.projection.TeamClassProjection;
import com.projectiontutorial.team.projection.TeamInterfaceProjection;
import com.projectiontutorial.team.projection.TeamRecordProjection;
import com.projectiontutorial.team.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@ActiveProfiles({"test", "postgres"})
@Transactional
@Slf4j
class ProjectionTutorialApplicationTests {

    @Autowired
    public MemberRepository memberRepository;

    @Autowired
    public TeamRepository teamRepository;

    @BeforeEach
    void init(){
//        for(int i = 0; i < 52; i++) {
//
//            String teamName = "팀"+i;
//            Integer teamNum = i;
//            String memberName = "멤버"+i;
//            String memberName2 = "멤버1"+i;
//            Integer memberAge = i;
//            Integer memberAge2 = i+1;
//
//            Team team = Team.builder().teamNum(teamNum).teamName(teamName).build();
//            Member member = Member.builder().name(memberName).age(memberAge).build();
//            Member member2 = Member.builder().name(memberName2).age(memberAge2).build();
//
//
//            teamRepository.save(team);
//            member.setTeam(team);
//            member2.setTeam(team);
//            memberRepository.save(member);
//            memberRepository.save(member2);
//        }

    }

    @Test
    void MemberProjectionTest() {

        List<Member> list = memberRepository.findAll();

        list.forEach(m -> {
                    log.info("m.getMemberId() : {}", m.getMemberId());
                    log.info("m.getName() : {}", m.getName());
                    log.info("m.getTeam().getTeamId() : {}", m.getTeam().getTeamId());
                    log.info("m.getTeam().getTeamName() : {}", m.getTeam().getTeamName());
        });

        List<MemberInterfaceProjection> memberInterfaceProjection = memberRepository.findAllBy(MemberInterfaceProjection.class);

        memberInterfaceProjection.forEach(m -> {
            log.info("m.getMemberId() : {}", m.getMemberId());
            log.info("m.getName() : {}", m.getName());
            log.info("m.getTeam().getTeamId() : {}", m.getTeam().getTeamId());
            log.info("m.getTeam().getTeamName() : {}", m.getTeam().getTeamName());
        });

        List<MemberRecordProjection> memberRecordProjection = memberRepository.findAllBy(MemberRecordProjection.class);

        memberRecordProjection.forEach(m -> {
            log.info("m.memberId : {}", m.memberId());
            log.info("m.name : {}", m.name());
            log.info("m.teamTeamId : {}", m.teamTeamId());
            log.info("m.teamTeamName : {}", m.teamTeamName());
        });


         List<MemberClassProjection> memberClassProjection = memberRepository.findAllBy(MemberClassProjection.class);

        memberClassProjection.forEach(m -> {
            log.info("m.getMemberId() : {}", m.getMemberId());
            log.info("m.getName() : {}", m.getName());
            log.info("m.getTeamId() : {}", m.getTeamId());
            log.info("m.getTeamName() : {}", m.getTeamName());
        });

        MemberRecordProjection memberProjection = memberRepository.findByMemberId(1L, MemberRecordProjection.class);
        log.info("memberProjection.memberId() : {}", memberProjection.memberId());
        log.info("memberProjection.name() : {}", memberProjection.name());
        log.info("memberProjection.teamTeamId() : {}", memberProjection.teamTeamId());
        log.info("memberProjection.teamTeamName() : {}", memberProjection.teamTeamName());

    }

    @Test
    void TeamProjectionTest(){

        List<Team> team = teamRepository.findAll();

        team.forEach(t -> {
            log.info("t.getTeamId() : {}", t.getTeamId());
            log.info("t.getTeamName() : {}", t.getTeamName());
            t.getMembers().forEach(m -> {
                log.info("m.getMemberId() : {}", m.getMemberId());
                log.info("m.getName() : {}", m.getName());
            });
        });


        List<TeamInterfaceProjection> teamInterfaceProjection = teamRepository.findAllBy(TeamInterfaceProjection.class);

        teamInterfaceProjection.forEach(r -> {
            log.info("r.getTeamId : {}", r.getTeamId());
            log.info("r.getTeamName : {}", r.getTeamName());
            r.getMembers().forEach(m -> {
                    log.info("m.getMemberId : {}", m.getMemberId());
                    log.info("m.getName : {}", m.getName());

            });
        });

        List<TeamRecordProjection> teamRecordProjectionList = teamRepository.findAllBy(TeamRecordProjection.class);

        teamRecordProjectionList.forEach(r -> {
            log.info("r.teamId : {}", r.teamId());
            log.info("r.teamName : {}", r.teamName());
            log.info("r.membersMemberId : {}", r.membersMemberId());
            log.info("r.membersName : {}", r.membersName());


        });

        List<TeamClassProjection> teamClassProjection = teamRepository.findAllBy(TeamClassProjection.class);
        log.info("teamClassProjection.size : {}", teamClassProjection.size());
        teamClassProjection.forEach(r -> {
            log.info("r.teamId : {}", r.getTeamId());
            log.info("r.teamName : {}", r.getTeamName());
            log.info("r.membersMemberId : {}", r.getMemberId());
            log.info("r.membersName : {}", r.getMemberName());
        });

        TeamRecordProjection teamRecordProjection = teamRepository.findByTeamId(1L, TeamRecordProjection.class);
        log.info("teamRecordProjection.teamId() : {}", teamRecordProjection.teamId());
        log.info("teamRecordProjection.teamName() : {}", teamRecordProjection.teamName());


    }

}
