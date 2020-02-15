// ==========================================================================
// APPLICATION TestDocumentDomDtd                                         XML
// --------------------------------------------------------------------------
// Lecture d'un fichier XML, utilisation d'un fichier DTD associe
// ==========================================================================

import java.io.*;                   // Pour File, IOException
import org.w3c.dom.*;               // Pour Document, Element, Node, NodeList
import javax.xml.parsers.*;         // Pour DocumentBuilder...
import org.xml.sax.*;               // Pour SAXException
                                    // (generee par parse de DocumentBuilder)

public class TestDocumentDomDtd
{
    public static void main(String args[]) throws IOException,
                                                  ParserConfigurationException,
                                                  SAXException
    {
        DocumentBuilderFactory usineParseurXml;
        DocumentBuilder parseurXml;

        File fichierXml;

        Document documentDom = null;
        Element racine;
        NodeList enfants;
        Node enfant;
        NamedNodeMap attributs;

// --------------------------------------------------------------------------
// Creation de l'objet DocumentBuilderFactory.
// --------------------------------------------------------------------------
        usineParseurXml = DocumentBuilderFactory.newInstance();

// --------------------------------------------------------------------------
// Options de l'objet DocumentBuilderFactory. Ces options s'appliquent au 
// parseur cree.
// --------------------------------------------------------------------------
// setIgnoringComments(true) :
//    les commentaires ne sont pas pris en compte.
//
// setIgnoringElementContentWhitespace(true) :
//    Elimine les blancs et caracteres de presentation.
//
// setValidating(true) :
//   Permet de valider la conformite du fichier XML par rapport a sa DTD.
//   Sans setValidating(true) : le parseur verifie la correction du XML.
//   Avec setValidating(true) : Le parseur verifie la conformite du XML avec 
//   la DTD. Si le  XML est correct, le parse continue.
// --------------------------------------------------------------------------
        usineParseurXml.setIgnoringComments(true);
        usineParseurXml.setIgnoringElementContentWhitespace(true);
        usineParseurXml.setValidating(true);

// --------------------------------------------------------------------------
// Creer le parseur et lui associer le gestionnaire d'erreur
// La classe ErreurDtd implemente l'interface ErrorHandler. En cas d'erreur
// (SAXParseException), c'est l'une des 3 méthodes de cette classe qui est 
// appelee. Cela permet de personnaliser les messages d'erreur.
// --------------------------------------------------------------------------
        parseurXml = usineParseurXml.newDocumentBuilder();
        parseurXml.setErrorHandler(new ErreurDtd());

// --------------------------------------------------------------------------
// Creation de l'objet File correspondant au fichier XML a convertir
// --------------------------------------------------------------------------
        fichierXml = new File("C:\\JAVA\\Fichiers\\fontDtdIncluse.xml");

// --------------------------------------------------------------------------
// Conversion du fichier en objet Document
// --------------------------------------------------------------------------
        try
        {
            documentDom = parseurXml.parse(fichierXml);

// --------------------------------------------------------------------------
// Recuperation de l'element racine de l'arbre
// --------------------------------------------------------------------------
            racine = documentDom.getDocumentElement();

// --------------------------------------------------------------------------
// Affichage du nom de la racine de l'arbre.
// --------------------------------------------------------------------------
            System.out.println("Contenu de l'arbre DOM :\n");
            System.out.println(racine.getNodeName());

// --------------------------------------------------------------------------
// Enfants de l'element racine.
// --------------------------------------------------------------------------
            enfants = racine.getChildNodes();

// --------------------------------------------------------------------------
// Affichage des enfants.
// --------------------------------------------------------------------------
            for (int i = 0; i < enfants.getLength(); i++)
            {
                enfant = enfants.item(i);

                if(enfant instanceof Element)
                {
                    System.out.print("   " + enfant.getNodeName() + " : ");
                    System.out.print(enfant.getFirstChild().getTextContent());

                    attributs = enfant.getAttributes();
                    if (attributs.getLength() > 0)
                    {
                        System.out.println(
                            " " + attributs.item(0).getTextContent()); 
                    }
                    else
                    {
                        System.out.println("");
                    }
                }

                if(enfant instanceof CharacterData)
                {
                    String commentaire = ((CharacterData)enfant).getData();
                    commentaire = commentaire.trim();
                    System.out.println("   " + commentaire);
                }
            }
        }
        catch(SAXParseException e)
        {
            System.out.println("Erreur de syntaxe XML");
        }
    }
}
