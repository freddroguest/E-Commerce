package hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
public class WebController implements WebMvcConfigurer {
	
	@Autowired
	ContactRepository repository;
	@Autowired
	ProduitRepository repositoryProduit;
	@Autowired
	CouleurRepository repositoryCouleur;
	@Autowired
	TypeProduitRepository repositoryTypeProduit;
	@Autowired
	ClientRepository repositoryClient;
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }
    
    //////////////////////////////////////////////////////// Model Attribute /////////////////////////////////////////////////////////////////////
    
    @ModelAttribute("someList")
    public ArrayList<Contact> getSomeList(){
    	ArrayList<Contact> l= new ArrayList<Contact>(repository.findAll());
    	return l;
    }
    
    @ModelAttribute("ListeProduit")
    public ArrayList<Produit> getListeProduit(){
    	ArrayList<Produit> l= new ArrayList<Produit>(repositoryProduit.findAll());
    	return l;
    }
    
    
   /* 
    @ModelAttribute("ListePanier")
    public Panier getListePanier(Long id){
    	Panier panier= repositoryPanier.findOne(id);
    	return panier;
    }
*/

    @ModelAttribute("ListeCouleur")
    public ArrayList<Couleur> getListeCouleur(){
    	ArrayList<Couleur> l= new ArrayList<Couleur>(repositoryCouleur.findAll());
    	return l;
    }
    
    @ModelAttribute("ListeClient")
    public ArrayList<Client> getListeClient(){
    	ArrayList<Client> l= new ArrayList<Client>(repositoryClient.findAll());
    	return l;
    }
    
    @ModelAttribute("ListeTypeProduit")
    public ArrayList<Type_produit> getListeTypeProduit(){
    	ArrayList<Type_produit> l= new ArrayList<Type_produit>(repositoryTypeProduit.findAll());
    	return l;
    }
    
    //////////////////////////////////////////////////////// GetMapping /////////////////////////////////////////////////////////////////////
    
    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model,HttpSession session, @CookieValue(value = "foo", defaultValue = "hello") String fooCookie) {
        name="Fred";
    	model.addAttribute("name", name);
        session.setAttribute("valueSession", 42);
        return "greeting";
    }
       
    @GetMapping("/form/{id}")
    public String showContact(Model model, @PathVariable("id") Long id)
    {
    	model.addAttribute("personForm",repository.findOne(id));
    	return "/form";
    }
  
    @GetMapping("/produitForm/{id}")
    public String showProduit(Model model, @PathVariable("id") Long id)
    {
    	model.addAttribute("produitForm",repositoryProduit.findOne(id));
    	List<Type_produit> list = repositoryTypeProduit.findAll();
    	model.addAttribute("typeProduit", list);
    	List<Couleur> listcouleur = repositoryCouleur.findAll();
    	model.addAttribute("lstCouleur", listcouleur);
    	return "/produitForm";
    }
    
    @GetMapping("/form")
    public String showForm(Model model) {
    	model.addAttribute("personForm", new Contact());
        return "form";
    }
    
    @GetMapping("/connexion")
    public String showConnexionForm(Model model) {
    	model.addAttribute("client", new Client());
        return "connexion";
    }
    
    @GetMapping("/inscription")
    public String showInscriptionForm(Model model) {
    	model.addAttribute("client", new Client());
        return "inscription";
    }
    
    @GetMapping("/typeProduitForm/{id}")
    public String showTypeProduit(Model model, @PathVariable("id") Long id)
    {
    	model.addAttribute("typeProduitForm",repositoryTypeProduit.findOne(id));
    	return "/typeProduitForm";
    }
    
    @GetMapping("/inscription/{id}")
    public String showClient(Model model, @PathVariable("id") Long id)
    {
    	model.addAttribute("client",repositoryClient.findOne(id));
    	return "/inscription";
    }
    
    @GetMapping("/typeProduitForm")
    public String showTypeProduit(Model model) {
    	model.addAttribute("typeProduitForm", new Type_produit());
        return "typeProduitForm";
    }
    
    @GetMapping("/deleteContact/{id}")
    public String deleteContact(@PathVariable("id") Long id)
    {
    	repository.delete(id);
    	return "redirect:/";
    }
    
    @GetMapping("/deleteProduit/{id}")
    public String deleteProduit(@PathVariable("id") Long id)
    {
    	repositoryProduit.delete(id);
    	return "redirect:/";
    }
    
    @GetMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable("id") Long id)
    {
    	repositoryClient.delete(id);
    	return "redirect:/";
    }
    
    @GetMapping("/deleteTypeProduit/{id}")
    public String deleteTypeProduit(@PathVariable("id") Long id)
    {
    	repositoryTypeProduit.delete(id);
    	return "redirect:/";
    }

    @GetMapping("/produitForm")
    public String showProduitForm(Model model) {
    	model.addAttribute("produitForm", new Produit());
    	List<Type_produit> list = repositoryTypeProduit.findAll();
    	model.addAttribute("typeProduit", list);
    	List<Couleur> listcouleur = repositoryCouleur.findAll();
    	model.addAttribute("lstCouleur", listcouleur);
        return "produitForm";
    }
    
    @GetMapping("/couleurForm")
    public String showCouleurForm(Model model) {
    	model.addAttribute("couleurForm", new Couleur());
        return "couleurForm";
    }
    
    @GetMapping("/deleteCouleur/{id}")
    public String deleteCouleur(@PathVariable("id") Long id)
    {
    	repositoryCouleur.delete(id);
    	return "redirect:/";
    }
    
    @GetMapping("/couleurForm/{id}")
    public String showCouleur(Model model, @PathVariable("id") Long id)
    {
    	model.addAttribute("couleurForm",repositoryCouleur.findOne(id));
    	return "/couleurForm";
    }
    /*
    @GetMapping("/panier")
    public String showPanier(Model model, @PathVariable("id") Long id) {
    	model.addAttribute("panier", repositoryPanier.findOne(id));
        return "panier";
    }*/
    //////////////////////////////////////////////////////// PostMapping /////////////////////////////////////////////////////////////////////
    
    @PostMapping("/typeProduitForm")
    public String checkTypeProduitInfo(@Valid Type_produit type_produit, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "typeProduitForm";
        }
        repositoryTypeProduit.save(type_produit);
        return "redirect:/";
    }
    
    @PostMapping("/inscription")
    public String checkclientInfo(@Valid Client client, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "inscription";
        }
        repositoryClient.save(client);
        return "redirect:/";
    }
    
    @PostMapping("/connexion")
    public String checkConnexionInfo(@Valid Client client, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "connexion";
        } 
        for(int i =0; i < repositoryClient.findAll().size(); i++)
        {
        	if(repositoryClient.findAll().get(i).getEmail().equals(client.getEmail()))
        	{
        		if(repositoryClient.findAll().get(i).getMdp().equals(client.getMdp()))
        		{
        			return "redirect:/";
        		}
        	}
        }
        
        
        return "connexion";
    }

    @PostMapping("/form")
    public String checkPersonInfo(@Valid Contact contact, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }
        repository.save(contact);
        return "redirect:/";
    }    
    
    @PostMapping("/produitForm")
    public String checkProduitInfo(@Valid Produit produit, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "produitForm";
        }
        
    	produit.setLibCouleur(repositoryCouleur.findOne(produit.getCouleur()).getLibelle());
    	produit.setLibtype(repositoryTypeProduit.findOne(produit.getIdType_produit()).getLibelle()); 	
    	
        repositoryProduit.save(produit);
        return "redirect:/";
    }    
    
    @PostMapping("/couleurForm")
    public String checkCouleurInfo(@Valid Couleur couleur, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "couleurForm";
        }
        repositoryCouleur.save(couleur);
        return "redirect:/";
    }
    

    
    ///////////////////////////////////////////////////// Other ////////////////////////////////////////////////////
    
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Validator getValidator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageCodesResolver getMessageCodesResolver() {
		// TODO Auto-generated method stub
		return null;
	}
}