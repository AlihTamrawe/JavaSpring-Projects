package axsos.java.jspdemo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SpringBootApplication
@Controller
public class NinjaGoldApplication {
	ArrayList<String> list =new ArrayList<String>();
	ArrayList<String> list2 =new ArrayList<String>();

	private int gold =0;
	public static void main(String[] args) {
		SpringApplication.run(NinjaGoldApplication.class, args);
	}
	@RequestMapping("/")
	public String first() {
		
		
		return "redirect:/gold";
	}
	
	@PostMapping("/reset")	
	public String resets( RedirectAttributes redirectAttributes) {
		
		list = new ArrayList<String>();
		list2 = new ArrayList<String>();
		this.setGold(0);
		
		

		
		
		return "redirect:/gold";
	}
	
	@RequestMapping("/gold")
	public String show(Model model) {
		model.addAttribute("list", list);
		
		model.addAttribute("gold", this.getGold());
		return "index.jsp";
	}
	
	@PostMapping("/farm")	
	public String farm( RedirectAttributes redirectAttributes) {
		Random rand = new Random();
		int num = rand.nextInt(10)+10;
		this.setGold(num+this.getGold());
		LocalDateTime l = LocalDateTime.now();
		list.add("You Entered a Farm and earned "+num+"gold.  "+l);
		
		
		redirectAttributes.addFlashAttribute("colur","green");

		
		
		return "redirect:/gold";
	}
	@PostMapping("/cave")	
	public String cave( RedirectAttributes redirectAttributes) {
		Random rand = new Random();
		int num = rand.nextInt(10)+10;
		this.setGold(num+this.getGold());
		LocalDateTime l = LocalDateTime.now();
		list.add("You Entered a Farm and earned "+num+"gold.  "+l);
		
		
		redirectAttributes.addFlashAttribute("colur","green");

		
		
		
		return "redirect:/gold";
	}
	@PostMapping("/house")	
	public String house(RedirectAttributes redirectAttributes) {
		
		Random rand = new Random();
		int num = rand.nextInt(10)+10;
		this.setGold(num+this.getGold());
		LocalDateTime l = LocalDateTime.now();
		list.add("You Entered a House and earned "+num+" gold.  "+l);
		
		
		redirectAttributes.addFlashAttribute("colur","green");

		
		
		return "redirect:/gold";
	}
	@PostMapping("/quest")	
	public String quest( RedirectAttributes redirectAttributes) {
		
		String style="green";
		Random rand = new Random();
		int ran = rand.nextInt(2)-1;
		int num =0;
		if(ran==0) {
			num=-50;
					
		}
		else {
			num=50;
		}
		if(num+this.getGold()>0) {
			this.setGold(num+this.getGold());

		}
		else
		{
			this.setGold(0);

		}
		LocalDateTime l = LocalDateTime.now();
		
		
		if(num==-50) {
			
			list2.add("You failed a Quest and lost "+num*-1+" gold.  Ouch"+l);			

		}
		else {
			list.add("You Entered a Quest and earned "+num+" gold.  "+l);

		}
		
		redirectAttributes.addFlashAttribute("list2",list2);

		
		return "redirect:/gold";
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
}
