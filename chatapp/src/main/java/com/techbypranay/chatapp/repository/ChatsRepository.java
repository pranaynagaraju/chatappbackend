package com.techbypranay.chatapp.repository;

import com.techbypranay.chatapp.entity.Chats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChatsRepository extends JpaRepository<Chats,Long>
{

}
