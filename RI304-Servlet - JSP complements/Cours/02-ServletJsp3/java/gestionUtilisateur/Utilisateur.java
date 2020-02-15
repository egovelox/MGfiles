package gestionUtilisateur;

public class Utilisateur implements java.io.Serializable
{
    private String nomUtil;
    private String motPasseUtil;
    
    public Utilisateur()
    {
    }

    public Utilisateur(String nomUtil, String motPasseUtil)
    {
        this.nomUtil = nomUtil;
        this.motPasseUtil = motPasseUtil;
    }

    public String getNomUtil()
    {
        return nomUtil;
    }

    public void setNomUtil(String nomUtil)
    {
        this.nomUtil = nomUtil;
    }

    public String getMotPasseUtil()
    {
        return motPasseUtil;
    }

    public void setMotPasseUtil(String motPasseUtil)
    {
        this.motPasseUtil = motPasseUtil;
    }
    
    public String toString()
    {
        return nomUtil + "(" + motPasseUtil +")";
    }
}
