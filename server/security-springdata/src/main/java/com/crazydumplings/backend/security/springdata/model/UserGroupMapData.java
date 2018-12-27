package com.crazydumplings.backend.security.springdata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.crazydumplings.backend.security.model.Group;
import com.crazydumplings.backend.security.model.User;
import com.crazydumplings.backend.security.model.UserGroupMap;

@Entity
@Table(name = "user_group_maps")
public class UserGroupMapData implements UserGroupMap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long      Id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserData  user;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupData group;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = (UserData) user;
    }

    @Override
    public Group getGroup() {
        return group;
    }

    @Override
    public void setGroup(Group group) {
        this.group = (GroupData) group;
    }

}
