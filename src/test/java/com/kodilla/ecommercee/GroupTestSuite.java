package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class GroupTestSuite {


    @Autowired
    private GroupRepository groupRepository;

    private final String GROUP_NAME_1 = "Owoce";
    private final String GROUP_NAME_2 = "Warzywa";
    private final String GROUP_NAME_3 = "Nabiał";
    private final String GROUP_NAME_4 = "Drogeria";

    @Test
    public void testShowAllGroups() {
        //Given
        List<Group> result = groupRepository.findAll();

        //Then
        assertTrue(result.isEmpty());

        //Cleanup
        groupRepository.deleteAll();
    }


    @Test
    public void testAddGroup() {
        //Given
        Group group1 = new Group(GROUP_NAME_1);
        Group group2 = new Group(GROUP_NAME_2);
        Group group3 = new Group(GROUP_NAME_3);
        Group group4 = new Group(GROUP_NAME_4);

        //When
        groupRepository.save(group1);
        groupRepository.save(group2);
        groupRepository.save(group3);
        groupRepository.save(group4);

        //Then
        assertEquals(4, groupRepository.findAll().size());
        //Cleanup
        groupRepository.deleteAll();

    }
    @Test
    public void getGroupByIdTest() {
        //Given
        Group groupToFind = groupRepository.save(Group.builder().name("Test_Group").build());

        //When
        Group result = groupRepository.findById(groupToFind.getId()).get();

        //Then
        assertEquals(groupToFind.getName(), result.getName());
        assertNotNull(result.getId());

        //Cleanup
        groupRepository.deleteAll();
    }



    @Test
    public void updateSelectedGroupTest() {
        //Given
        String renameGroup = "Test_Group";
        Group newGroupNameToSave = groupRepository.save(Group.builder().name("Test_Group").build());

        //When
        newGroupNameToSave.setName(renameGroup);
        groupRepository.save(newGroupNameToSave);
        List<Group> groupList = groupRepository.findAll();

        //Then
        assertEquals(renameGroup, newGroupNameToSave.getName());
        assertEquals(1, groupList.size());

        //Cleanup
        groupRepository.deleteAll();
    }

}