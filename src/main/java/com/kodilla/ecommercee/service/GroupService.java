package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    public Group getGroup(Long id) {
        return groupRepository.findById(id).orElse(null);
    }
}
