package com.groceryListBuilder.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * The type Grocery list.
 *
 * @author Sydney St. Clair
 */
@Entity(name = "GroceryList")
@Table(name = "grocery_list")
public class GroceryList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "listId")
    private int listId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    @ManyToOne
    @JoinColumn(name="userId", referencedColumnName = "userId", nullable = false)
    private User user;

    /**
     * Instantiates a new Grocery list.
     */
    public GroceryList() {
    }

    /**
     * Instantiates a new Grocery list.
     *
     * @param createDate the create date
     * @param updateDate the update date
     * @param user       the user
     */
    public GroceryList(LocalDateTime createDate, LocalDateTime updateDate, User user) {
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.user = user;
    }

    /**
     * Gets list id.
     *
     * @return the list id
     */
    public int getListId() {
        return listId;
    }

    /**
     * Sets list id.
     *
     * @param listId the list id
     */
    public void setListId(int listId) {
        this.listId = listId;
    }

    /**
     * Gets create date.
     *
     * @return the create date
     */
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * Sets create date.
     *
     * @param createDate the create date
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * Gets update date.
     *
     * @return the update date
     */
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    /**
     * Sets update date.
     *
     * @param updateDate the update date
     */
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "GroceryList{" +
                "listId=" + listId +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", user=" + user +
                '}';
    }
}
