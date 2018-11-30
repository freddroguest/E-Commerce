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
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }
    
    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model,HttpSession session, @CookieValue(value = "foo", defaultValue = "hello") String fooCookie) {
        name="Fred";
    	model.addAttribute("name", name);
        session.setAttribute("valueSession", 42);
        return "greeting";
    }
    
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

    @ModelAttribute("ListeCouleur")
    public ArrayList<Couleur> getListeCouleur(){
    	ArrayList<Couleur> l= new ArrayList<Couleur>(repositoryCouleur.findAll());
    	return l;
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
    	return "/produitForm";
    }
    
    @GetMapping("/form")
    public String showForm(Model model) {
    	model.addAttribute("personForm", new Contact());
        return "form";
    }

    @PostMapping("/form")
    public String checkPersonInfo(@Valid Contact contact, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }
        repository.save(contact);
        return "redirect:/";
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

    @GetMapping("/produitForm")
    public String showProduitForm(Model model) {
    	model.addAttribute("produitForm", new Produit());
        return "produitForm";
    }
    
    @PostMapping("/produitForm")
    public String checkProduitInfo(@Valid Produit produit, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "produitForm";
        }
        repositoryProduit.save(produit);
        return "redirect:/";
    }
    
    @GetMapping("/couleurForm")
    public String showCouleurForm(Model model) {
    	model.addAttribute("couleurForm", new Couleur());
        return "couleurForm";
    }
    
    @PostMapping("/couleurForm")
    public String checkCouleurInfo(@Valid Couleur couleur, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "couleurForm";
        }
        repositoryCouleur.save(couleur);
        return "redirect:/";
    }
    
    
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