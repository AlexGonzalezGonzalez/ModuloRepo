/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eclipse.jgit.crearepo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GitHub;
import org.openide.awt.ActionID;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Tools",
        id = "org.eclipse.jgit.crearepo.Repositorio"
)
@ActionRegistration(
        displayName = "#CTL_Repositorio"
)
@Messages("CTL_Repositorio=Repositorio")
public final class Repositorio implements ActionListener {
    /*
    Metodo que pide el nombre del repositorio y lo crea
    */
    @Override
    public void actionPerformed(ActionEvent e) {
               String nombre=JOptionPane.showInputDialog("Inserte el nombre del repositorio:");
        try{
            GitHub github=GitHub.connect();
            GHCreateRepositoryBuilder builder;
            builder=github.createRepository(nombre);
            builder.create();
        }catch(IOException ex){
            System.out.println("Error:"+ex);
        }
}
    }

