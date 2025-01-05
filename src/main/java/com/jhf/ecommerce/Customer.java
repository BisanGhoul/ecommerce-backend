package com.jhf.ecommerce;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "customer", schema = "ecommerce", uniqueConstraints = {
        @UniqueConstraint(name = "email", columnNames = {"email"}),
        @UniqueConstraint(name = "username", columnNames = {"username"})
})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "address_id")
    private address address;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "profile_pic_id")
    private Image profilePic;

    @Size(max = 255)
    @NotNull
    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Size(max = 255)
    @NotNull
    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Size(max = 255)
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @Size(max = 255)
    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Size(max = 255)
    @NotNull
    @Column(name = "username", nullable = false)
    private String username;

    @OneToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "wishlist_id")
    private Wishlist wishlist;

    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    private Set<Order> orders = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public com.jhf.ecommerce.address getAddress() {
        return address;
    }

    public void setAddress(com.jhf.ecommerce.address address) {
        this.address = address;
    }

    public Image getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(Image profilePic) {
        this.profilePic = profilePic;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

}