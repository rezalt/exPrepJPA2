/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.*;
import facade.Facade;
import javax.persistence.Persistence;
/**
 *
 * @author olls
 */
public class FacadeTester
{
    public static void main(String[] args)
    {
        
        Facade ft = new Facade( Persistence.createEntityManagerFactory( "PersJPA2PU" ) );
        ft.addPerson( new Student() );
        ft.addPerson( new Employee() );
        
        System.out.println("" + ft.FindPerson(1L)); // Should read out entity.Student something something.
        
    }
}
