package  com.ird.faa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.*;
import java.util.stream.Stream;

import com.ird.faa.security.common.AuthoritiesConstants;
import com.ird.faa.security.bean.User;
import com.ird.faa.security.bean.Permission;
import com.ird.faa.security.bean.Role;
import com.ird.faa.security.service.facade.UserService;
import com.ird.faa.security.service.facade.RoleService;
import com.ird.faa.bean.Chercheur;


@SpringBootApplication
public class FaaApplication {
public static ConfigurableApplicationContext ctx;

public static void main(String[] args) {
ctx=SpringApplication.run(FaaApplication.class, args);
}

public static ConfigurableApplicationContext getCtx() {
return ctx;
}

@Bean
public CommandLineRunner demo(UserService userService, RoleService roleService
) {
return (args) -> {
if(true){
    Map<String,String> etats=new HashMap<>();
    etats.put("Initialisé","initialise");
    etats.put("En cours","encours");
    etats.put("Terminé","termine");


    // Role chercheur
        /* Chercheur userForChercheur = new Chercheur("chercheur");

    Role roleForChercheur = new Role();
    roleForChercheur.setAuthority(AuthoritiesConstants.CHERCHEUR);
    List<Permission> permissionsForChercheur = new ArrayList<>();
    addPermissionForChercheur(permissionsForChercheur);
    roleForChercheur.setPermissions(permissionsForChercheur);
    if(userForChercheur.getRoles()==null)
    userForChercheur.setRoles(new ArrayList<>());

    userForChercheur.getRoles().add(roleForChercheur);
    userService.save(userForChercheur);*/


    // Role admin
        User userForAdmin = new User("admin");

    Role roleForAdmin = new Role();
    roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
    List<Permission> permissionsForAdmin = new ArrayList<>();
    addPermissionForAdmin(permissionsForAdmin);
    roleForAdmin.setPermissions(permissionsForAdmin);
    if(userForAdmin.getRoles()==null)
    userForAdmin.setRoles(new ArrayList<>());

    userForAdmin.getRoles().add(roleForAdmin);
    userService.save(userForAdmin);


    // Role maitreouvrage
        User userForMaitreouvrage = new User("maitreouvrage");

    Role roleForMaitreouvrage = new Role();
    roleForMaitreouvrage.setAuthority(AuthoritiesConstants.MAITREOUVRAGE);
    List<Permission> permissionsForMaitreouvrage = new ArrayList<>();
    addPermissionForMaitreouvrage(permissionsForMaitreouvrage);
    roleForMaitreouvrage.setPermissions(permissionsForMaitreouvrage);
    if(userForMaitreouvrage.getRoles()==null)
    userForMaitreouvrage.setRoles(new ArrayList<>());

    userForMaitreouvrage.getRoles().add(roleForMaitreouvrage);
    userService.save(userForMaitreouvrage);
    }
        };
        }

        private static void addPermissionForChercheur(List
        <Permission> permissions){
                permissions.add(new Permission("EtatLot.edit"));
                permissions.add(new Permission("EtatLot.list"));
                permissions.add(new Permission("EtatLot.view"));
                permissions.add(new Permission("EtatLot.add"));
                permissions.add(new Permission("EtatLot.delete"));
                permissions.add(new Permission("Charge.edit"));
                permissions.add(new Permission("Charge.list"));
                permissions.add(new Permission("Charge.view"));
                permissions.add(new Permission("Charge.add"));
                permissions.add(new Permission("Charge.delete"));
                permissions.add(new Permission("CategorieCharge.edit"));
                permissions.add(new Permission("CategorieCharge.list"));
                permissions.add(new Permission("CategorieCharge.view"));
                permissions.add(new Permission("CategorieCharge.add"));
                permissions.add(new Permission("CategorieCharge.delete"));
                permissions.add(new Permission("CategorieEmploye.edit"));
                permissions.add(new Permission("CategorieEmploye.list"));
                permissions.add(new Permission("CategorieEmploye.view"));
                permissions.add(new Permission("CategorieEmploye.add"));
                permissions.add(new Permission("CategorieEmploye.delete"));
                permissions.add(new Permission("PaiementMarche.edit"));
                permissions.add(new Permission("PaiementMarche.list"));
                permissions.add(new Permission("PaiementMarche.view"));
                permissions.add(new Permission("PaiementMarche.add"));
                permissions.add(new Permission("PaiementMarche.delete"));
                permissions.add(new Permission("Prime.edit"));
                permissions.add(new Permission("Prime.list"));
                permissions.add(new Permission("Prime.view"));
                permissions.add(new Permission("Prime.add"));
                permissions.add(new Permission("Prime.delete"));
                permissions.add(new Permission("Chercheur.edit"));
                permissions.add(new Permission("Chercheur.list"));
                permissions.add(new Permission("Chercheur.view"));
                permissions.add(new Permission("Chercheur.add"));
                permissions.add(new Permission("Chercheur.delete"));
                permissions.add(new Permission("Produit.edit"));
                permissions.add(new Permission("Produit.list"));
                permissions.add(new Permission("Produit.view"));
                permissions.add(new Permission("Produit.add"));
                permissions.add(new Permission("Produit.delete"));
                permissions.add(new Permission("Employe.edit"));
                permissions.add(new Permission("Employe.list"));
                permissions.add(new Permission("Employe.view"));
                permissions.add(new Permission("Employe.add"));
                permissions.add(new Permission("Employe.delete"));
                permissions.add(new Permission("TypePieceJointe.edit"));
                permissions.add(new Permission("TypePieceJointe.list"));
                permissions.add(new Permission("TypePieceJointe.view"));
                permissions.add(new Permission("TypePieceJointe.add"));
                permissions.add(new Permission("TypePieceJointe.delete"));
                permissions.add(new Permission("PaiementLot.edit"));
                permissions.add(new Permission("PaiementLot.list"));
                permissions.add(new Permission("PaiementLot.view"));
                permissions.add(new Permission("PaiementLot.add"));
                permissions.add(new Permission("PaiementLot.delete"));
                permissions.add(new Permission("CompteComptable.edit"));
                permissions.add(new Permission("CompteComptable.list"));
                permissions.add(new Permission("CompteComptable.view"));
                permissions.add(new Permission("CompteComptable.add"));
                permissions.add(new Permission("CompteComptable.delete"));
                permissions.add(new Permission("ClasseComptable.edit"));
                permissions.add(new Permission("ClasseComptable.list"));
                permissions.add(new Permission("ClasseComptable.view"));
                permissions.add(new Permission("ClasseComptable.add"));
                permissions.add(new Permission("ClasseComptable.delete"));
                permissions.add(new Permission("Marche.edit"));
                permissions.add(new Permission("Marche.list"));
                permissions.add(new Permission("Marche.view"));
                permissions.add(new Permission("Marche.add"));
                permissions.add(new Permission("Marche.delete"));
                permissions.add(new Permission("TypePaiementMarche.edit"));
                permissions.add(new Permission("TypePaiementMarche.list"));
                permissions.add(new Permission("TypePaiementMarche.view"));
                permissions.add(new Permission("TypePaiementMarche.add"));
                permissions.add(new Permission("TypePaiementMarche.delete"));
                permissions.add(new Permission("MarcheEmploye.edit"));
                permissions.add(new Permission("MarcheEmploye.list"));
                permissions.add(new Permission("MarcheEmploye.view"));
                permissions.add(new Permission("MarcheEmploye.add"));
                permissions.add(new Permission("MarcheEmploye.delete"));
                permissions.add(new Permission("TypePaiementLot.edit"));
                permissions.add(new Permission("TypePaiementLot.list"));
                permissions.add(new Permission("TypePaiementLot.view"));
                permissions.add(new Permission("TypePaiementLot.add"));
                permissions.add(new Permission("TypePaiementLot.delete"));
                permissions.add(new Permission("MaitreOuvrage.edit"));
                permissions.add(new Permission("MaitreOuvrage.list"));
                permissions.add(new Permission("MaitreOuvrage.view"));
                permissions.add(new Permission("MaitreOuvrage.add"));
                permissions.add(new Permission("MaitreOuvrage.delete"));
                permissions.add(new Permission("EtatCharge.edit"));
                permissions.add(new Permission("EtatCharge.list"));
                permissions.add(new Permission("EtatCharge.view"));
                permissions.add(new Permission("EtatCharge.add"));
                permissions.add(new Permission("EtatCharge.delete"));
                permissions.add(new Permission("Lot.edit"));
                permissions.add(new Permission("Lot.list"));
                permissions.add(new Permission("Lot.view"));
                permissions.add(new Permission("Lot.add"));
                permissions.add(new Permission("Lot.delete"));
                permissions.add(new Permission("SousClasseComptable.edit"));
                permissions.add(new Permission("SousClasseComptable.list"));
                permissions.add(new Permission("SousClasseComptable.view"));
                permissions.add(new Permission("SousClasseComptable.add"));
                permissions.add(new Permission("SousClasseComptable.delete"));
                permissions.add(new Permission("PieceJointeCharge.edit"));
                permissions.add(new Permission("PieceJointeCharge.list"));
                permissions.add(new Permission("PieceJointeCharge.view"));
                permissions.add(new Permission("PieceJointeCharge.add"));
                permissions.add(new Permission("PieceJointeCharge.delete"));
                permissions.add(new Permission("EtatMarche.edit"));
                permissions.add(new Permission("EtatMarche.list"));
                permissions.add(new Permission("EtatMarche.view"));
                permissions.add(new Permission("EtatMarche.add"));
                permissions.add(new Permission("EtatMarche.delete"));
                permissions.add(new Permission("LotEmploye.edit"));
                permissions.add(new Permission("LotEmploye.list"));
                permissions.add(new Permission("LotEmploye.view"));
                permissions.add(new Permission("LotEmploye.add"));
                permissions.add(new Permission("LotEmploye.delete"));
            }
        private static void addPermissionForAdmin(List
        <Permission> permissions){
                permissions.add(new Permission("EtatLot.edit"));
                permissions.add(new Permission("EtatLot.list"));
                permissions.add(new Permission("EtatLot.view"));
                permissions.add(new Permission("EtatLot.add"));
                permissions.add(new Permission("EtatLot.delete"));
                permissions.add(new Permission("Charge.edit"));
                permissions.add(new Permission("Charge.list"));
                permissions.add(new Permission("Charge.view"));
                permissions.add(new Permission("Charge.add"));
                permissions.add(new Permission("Charge.delete"));
                permissions.add(new Permission("CategorieCharge.edit"));
                permissions.add(new Permission("CategorieCharge.list"));
                permissions.add(new Permission("CategorieCharge.view"));
                permissions.add(new Permission("CategorieCharge.add"));
                permissions.add(new Permission("CategorieCharge.delete"));
                permissions.add(new Permission("CategorieEmploye.edit"));
                permissions.add(new Permission("CategorieEmploye.list"));
                permissions.add(new Permission("CategorieEmploye.view"));
                permissions.add(new Permission("CategorieEmploye.add"));
                permissions.add(new Permission("CategorieEmploye.delete"));
                permissions.add(new Permission("PaiementMarche.edit"));
                permissions.add(new Permission("PaiementMarche.list"));
                permissions.add(new Permission("PaiementMarche.view"));
                permissions.add(new Permission("PaiementMarche.add"));
                permissions.add(new Permission("PaiementMarche.delete"));
                permissions.add(new Permission("Prime.edit"));
                permissions.add(new Permission("Prime.list"));
                permissions.add(new Permission("Prime.view"));
                permissions.add(new Permission("Prime.add"));
                permissions.add(new Permission("Prime.delete"));
                permissions.add(new Permission("Chercheur.edit"));
                permissions.add(new Permission("Chercheur.list"));
                permissions.add(new Permission("Chercheur.view"));
                permissions.add(new Permission("Chercheur.add"));
                permissions.add(new Permission("Chercheur.delete"));
                permissions.add(new Permission("Produit.edit"));
                permissions.add(new Permission("Produit.list"));
                permissions.add(new Permission("Produit.view"));
                permissions.add(new Permission("Produit.add"));
                permissions.add(new Permission("Produit.delete"));
                permissions.add(new Permission("Employe.edit"));
                permissions.add(new Permission("Employe.list"));
                permissions.add(new Permission("Employe.view"));
                permissions.add(new Permission("Employe.add"));
                permissions.add(new Permission("Employe.delete"));
                permissions.add(new Permission("TypePieceJointe.edit"));
                permissions.add(new Permission("TypePieceJointe.list"));
                permissions.add(new Permission("TypePieceJointe.view"));
                permissions.add(new Permission("TypePieceJointe.add"));
                permissions.add(new Permission("TypePieceJointe.delete"));
                permissions.add(new Permission("PaiementLot.edit"));
                permissions.add(new Permission("PaiementLot.list"));
                permissions.add(new Permission("PaiementLot.view"));
                permissions.add(new Permission("PaiementLot.add"));
                permissions.add(new Permission("PaiementLot.delete"));
                permissions.add(new Permission("CompteComptable.edit"));
                permissions.add(new Permission("CompteComptable.list"));
                permissions.add(new Permission("CompteComptable.view"));
                permissions.add(new Permission("CompteComptable.add"));
                permissions.add(new Permission("CompteComptable.delete"));
                permissions.add(new Permission("ClasseComptable.edit"));
                permissions.add(new Permission("ClasseComptable.list"));
                permissions.add(new Permission("ClasseComptable.view"));
                permissions.add(new Permission("ClasseComptable.add"));
                permissions.add(new Permission("ClasseComptable.delete"));
                permissions.add(new Permission("Marche.edit"));
                permissions.add(new Permission("Marche.list"));
                permissions.add(new Permission("Marche.view"));
                permissions.add(new Permission("Marche.add"));
                permissions.add(new Permission("Marche.delete"));
                permissions.add(new Permission("TypePaiementMarche.edit"));
                permissions.add(new Permission("TypePaiementMarche.list"));
                permissions.add(new Permission("TypePaiementMarche.view"));
                permissions.add(new Permission("TypePaiementMarche.add"));
                permissions.add(new Permission("TypePaiementMarche.delete"));
                permissions.add(new Permission("MarcheEmploye.edit"));
                permissions.add(new Permission("MarcheEmploye.list"));
                permissions.add(new Permission("MarcheEmploye.view"));
                permissions.add(new Permission("MarcheEmploye.add"));
                permissions.add(new Permission("MarcheEmploye.delete"));
                permissions.add(new Permission("TypePaiementLot.edit"));
                permissions.add(new Permission("TypePaiementLot.list"));
                permissions.add(new Permission("TypePaiementLot.view"));
                permissions.add(new Permission("TypePaiementLot.add"));
                permissions.add(new Permission("TypePaiementLot.delete"));
                permissions.add(new Permission("MaitreOuvrage.edit"));
                permissions.add(new Permission("MaitreOuvrage.list"));
                permissions.add(new Permission("MaitreOuvrage.view"));
                permissions.add(new Permission("MaitreOuvrage.add"));
                permissions.add(new Permission("MaitreOuvrage.delete"));
                permissions.add(new Permission("EtatCharge.edit"));
                permissions.add(new Permission("EtatCharge.list"));
                permissions.add(new Permission("EtatCharge.view"));
                permissions.add(new Permission("EtatCharge.add"));
                permissions.add(new Permission("EtatCharge.delete"));
                permissions.add(new Permission("Lot.edit"));
                permissions.add(new Permission("Lot.list"));
                permissions.add(new Permission("Lot.view"));
                permissions.add(new Permission("Lot.add"));
                permissions.add(new Permission("Lot.delete"));
                permissions.add(new Permission("SousClasseComptable.edit"));
                permissions.add(new Permission("SousClasseComptable.list"));
                permissions.add(new Permission("SousClasseComptable.view"));
                permissions.add(new Permission("SousClasseComptable.add"));
                permissions.add(new Permission("SousClasseComptable.delete"));
                permissions.add(new Permission("PieceJointeCharge.edit"));
                permissions.add(new Permission("PieceJointeCharge.list"));
                permissions.add(new Permission("PieceJointeCharge.view"));
                permissions.add(new Permission("PieceJointeCharge.add"));
                permissions.add(new Permission("PieceJointeCharge.delete"));
                permissions.add(new Permission("EtatMarche.edit"));
                permissions.add(new Permission("EtatMarche.list"));
                permissions.add(new Permission("EtatMarche.view"));
                permissions.add(new Permission("EtatMarche.add"));
                permissions.add(new Permission("EtatMarche.delete"));
                permissions.add(new Permission("LotEmploye.edit"));
                permissions.add(new Permission("LotEmploye.list"));
                permissions.add(new Permission("LotEmploye.view"));
                permissions.add(new Permission("LotEmploye.add"));
                permissions.add(new Permission("LotEmploye.delete"));
            }
        private static void addPermissionForMaitreouvrage(List
        <Permission> permissions){
                permissions.add(new Permission("EtatLot.edit"));
                permissions.add(new Permission("EtatLot.list"));
                permissions.add(new Permission("EtatLot.view"));
                permissions.add(new Permission("EtatLot.add"));
                permissions.add(new Permission("EtatLot.delete"));
                permissions.add(new Permission("Charge.edit"));
                permissions.add(new Permission("Charge.list"));
                permissions.add(new Permission("Charge.view"));
                permissions.add(new Permission("Charge.add"));
                permissions.add(new Permission("Charge.delete"));
                permissions.add(new Permission("CategorieCharge.edit"));
                permissions.add(new Permission("CategorieCharge.list"));
                permissions.add(new Permission("CategorieCharge.view"));
                permissions.add(new Permission("CategorieCharge.add"));
                permissions.add(new Permission("CategorieCharge.delete"));
                permissions.add(new Permission("CategorieEmploye.edit"));
                permissions.add(new Permission("CategorieEmploye.list"));
                permissions.add(new Permission("CategorieEmploye.view"));
                permissions.add(new Permission("CategorieEmploye.add"));
                permissions.add(new Permission("CategorieEmploye.delete"));
                permissions.add(new Permission("PaiementMarche.edit"));
                permissions.add(new Permission("PaiementMarche.list"));
                permissions.add(new Permission("PaiementMarche.view"));
                permissions.add(new Permission("PaiementMarche.add"));
                permissions.add(new Permission("PaiementMarche.delete"));
                permissions.add(new Permission("Prime.edit"));
                permissions.add(new Permission("Prime.list"));
                permissions.add(new Permission("Prime.view"));
                permissions.add(new Permission("Prime.add"));
                permissions.add(new Permission("Prime.delete"));
                permissions.add(new Permission("Chercheur.edit"));
                permissions.add(new Permission("Chercheur.list"));
                permissions.add(new Permission("Chercheur.view"));
                permissions.add(new Permission("Chercheur.add"));
                permissions.add(new Permission("Chercheur.delete"));
                permissions.add(new Permission("Produit.edit"));
                permissions.add(new Permission("Produit.list"));
                permissions.add(new Permission("Produit.view"));
                permissions.add(new Permission("Produit.add"));
                permissions.add(new Permission("Produit.delete"));
                permissions.add(new Permission("Employe.edit"));
                permissions.add(new Permission("Employe.list"));
                permissions.add(new Permission("Employe.view"));
                permissions.add(new Permission("Employe.add"));
                permissions.add(new Permission("Employe.delete"));
                permissions.add(new Permission("TypePieceJointe.edit"));
                permissions.add(new Permission("TypePieceJointe.list"));
                permissions.add(new Permission("TypePieceJointe.view"));
                permissions.add(new Permission("TypePieceJointe.add"));
                permissions.add(new Permission("TypePieceJointe.delete"));
                permissions.add(new Permission("PaiementLot.edit"));
                permissions.add(new Permission("PaiementLot.list"));
                permissions.add(new Permission("PaiementLot.view"));
                permissions.add(new Permission("PaiementLot.add"));
                permissions.add(new Permission("PaiementLot.delete"));
                permissions.add(new Permission("CompteComptable.edit"));
                permissions.add(new Permission("CompteComptable.list"));
                permissions.add(new Permission("CompteComptable.view"));
                permissions.add(new Permission("CompteComptable.add"));
                permissions.add(new Permission("CompteComptable.delete"));
                permissions.add(new Permission("ClasseComptable.edit"));
                permissions.add(new Permission("ClasseComptable.list"));
                permissions.add(new Permission("ClasseComptable.view"));
                permissions.add(new Permission("ClasseComptable.add"));
                permissions.add(new Permission("ClasseComptable.delete"));
                permissions.add(new Permission("Marche.edit"));
                permissions.add(new Permission("Marche.list"));
                permissions.add(new Permission("Marche.view"));
                permissions.add(new Permission("Marche.add"));
                permissions.add(new Permission("Marche.delete"));
                permissions.add(new Permission("TypePaiementMarche.edit"));
                permissions.add(new Permission("TypePaiementMarche.list"));
                permissions.add(new Permission("TypePaiementMarche.view"));
                permissions.add(new Permission("TypePaiementMarche.add"));
                permissions.add(new Permission("TypePaiementMarche.delete"));
                permissions.add(new Permission("MarcheEmploye.edit"));
                permissions.add(new Permission("MarcheEmploye.list"));
                permissions.add(new Permission("MarcheEmploye.view"));
                permissions.add(new Permission("MarcheEmploye.add"));
                permissions.add(new Permission("MarcheEmploye.delete"));
                permissions.add(new Permission("TypePaiementLot.edit"));
                permissions.add(new Permission("TypePaiementLot.list"));
                permissions.add(new Permission("TypePaiementLot.view"));
                permissions.add(new Permission("TypePaiementLot.add"));
                permissions.add(new Permission("TypePaiementLot.delete"));
                permissions.add(new Permission("MaitreOuvrage.edit"));
                permissions.add(new Permission("MaitreOuvrage.list"));
                permissions.add(new Permission("MaitreOuvrage.view"));
                permissions.add(new Permission("MaitreOuvrage.add"));
                permissions.add(new Permission("MaitreOuvrage.delete"));
                permissions.add(new Permission("EtatCharge.edit"));
                permissions.add(new Permission("EtatCharge.list"));
                permissions.add(new Permission("EtatCharge.view"));
                permissions.add(new Permission("EtatCharge.add"));
                permissions.add(new Permission("EtatCharge.delete"));
                permissions.add(new Permission("Lot.edit"));
                permissions.add(new Permission("Lot.list"));
                permissions.add(new Permission("Lot.view"));
                permissions.add(new Permission("Lot.add"));
                permissions.add(new Permission("Lot.delete"));
                permissions.add(new Permission("SousClasseComptable.edit"));
                permissions.add(new Permission("SousClasseComptable.list"));
                permissions.add(new Permission("SousClasseComptable.view"));
                permissions.add(new Permission("SousClasseComptable.add"));
                permissions.add(new Permission("SousClasseComptable.delete"));
                permissions.add(new Permission("PieceJointeCharge.edit"));
                permissions.add(new Permission("PieceJointeCharge.list"));
                permissions.add(new Permission("PieceJointeCharge.view"));
                permissions.add(new Permission("PieceJointeCharge.add"));
                permissions.add(new Permission("PieceJointeCharge.delete"));
                permissions.add(new Permission("EtatMarche.edit"));
                permissions.add(new Permission("EtatMarche.list"));
                permissions.add(new Permission("EtatMarche.view"));
                permissions.add(new Permission("EtatMarche.add"));
                permissions.add(new Permission("EtatMarche.delete"));
                permissions.add(new Permission("LotEmploye.edit"));
                permissions.add(new Permission("LotEmploye.list"));
                permissions.add(new Permission("LotEmploye.view"));
                permissions.add(new Permission("LotEmploye.add"));
                permissions.add(new Permission("LotEmploye.delete"));
            }


            }


