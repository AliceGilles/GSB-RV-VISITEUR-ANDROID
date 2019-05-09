package fr.gsb.rv.technique;

import fr.gsb.rv.entites.Visiteur;

public class Session {

    private static Session session = null ;
    private Visiteur leVisiteur = null ;

    public Session(Visiteur leVisiteur) {
        this.leVisiteur = leVisiteur;
    }

    public static Session getSession() {
        return session;
    }

    public Visiteur getLeVisiteur() {
        return leVisiteur;
    }

    public static void ouvrir( Visiteur leVisiteur){
        Session.session = new Session(leVisiteur) ;
    }

    public static void fermer() {
        Session.session = null ;
    }
}
