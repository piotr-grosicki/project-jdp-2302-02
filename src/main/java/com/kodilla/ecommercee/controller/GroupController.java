package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.GroupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ecommercee/groups")
@RequiredArgsConstructor
public class GroupController {
    @GetMapping
    public List<GroupDto> getAllGroups() {
        return new ArrayList<>();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto) {
       // return new GroupDto(1L, "Test Name");
    }


    @GetMapping(value = "{groupId}")
    public GroupDto getGroupByid(@PathVariable Long groupId) {
        return new GroupDto(1L, "Test Group Name");
    }


    @PutMapping
    public GroupDto editOneGroup(@RequestBody GroupDto groupDto) {
        return new GroupDto(1L, "Edited test Name");
    }

}
