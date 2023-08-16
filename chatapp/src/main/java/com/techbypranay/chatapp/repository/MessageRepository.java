package com.techbypranay.chatapp.repository;

import com.techbypranay.chatapp.entity.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Messages,Long> {
}
