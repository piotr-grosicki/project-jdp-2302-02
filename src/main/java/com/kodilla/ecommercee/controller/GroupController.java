package com.kodilla.ecommercee.controller;
import com.kodilla.ecommercee.domain.*;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/groups")
@RequiredArgsConstructor
public class GroupController {

    public List<GroupDto> getTasks() {
        return new ArrayList<>();
    }

    public GroupDto getTask(Long taskId) {
        return new GroupDto(1L, "test title");
    }

    public void deleteTask(Long taskId) {

    }

    public GroupDto updateTask(GroupDto groupDto) {
        return new GroupDto(1L, "Edited test title");
    }

    public void createTask(GroupDto groupDto) {

    }

}
