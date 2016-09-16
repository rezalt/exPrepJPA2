/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author olls
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Så vi ikke bare har ét kæmpe person table. :)
public class Person implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthDate;
    private int age;
    private boolean isMarried;
    
    @ManyToOne
    private Person supervisor;
    
    @OneToMany
    List<Person> supervised = new ArrayList<>();
    
    @OneToMany
    List<Grade> grades = new ArrayList<>();

    public Person()
    {
    }

    public Long getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    public int getAge()
    {
        return age;
    }

    public boolean isIsMarried()
    {
        return isMarried;
    }

    public Person getSupervisor()
    {
        return supervisor;
    }

    public List<Person> getSupervised()
    {
        return supervised;
    }

    public List<Grade> getGrades()
    {
        return grades;
    }

    
    public void setId(Long id)
    {
        this.id = id;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setIsMarried(boolean isMarried)
    {
        this.isMarried = isMarried;
    }

    public void setSupervisor(Person supervisor)
    {
        this.supervisor = supervisor;
    }

    public void setSupervised(List<Person> supervised)
    {
        this.supervised = supervised;
    }

    public void setGrades(List<Grade> grades)
    {
        this.grades = grades;
    }

    
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entity.Person[ id=" + id + " ]";
    }

}
