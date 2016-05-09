package com.pie.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.List;

import com.pie.model.*;
import com.pie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/**")
public class AppController {

    @Autowired
    UserService userService;

    @Autowired
    JourneyService journeyService;

    @Autowired
    CouchsurferService couchsurferService;

    @Autowired
    TransportService transportService;

    @Autowired
    ExpenseService expenseService;

    @Autowired
    MemberService memberService;

    @Autowired
    MessageSource messageSource;

    public int currentId;;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listUsers(ModelMap modelMap){

        List<User> users = userService.findAllUsers();
        int userCount = userService.getUserCount();
        modelMap.addAttribute("users", users);
        modelMap.addAttribute("userCount", userCount);
        return "index";
    }

    @RequestMapping(value = { "/login", "/afterlogin" } )
    public String login(@ModelAttribute("login")String username,
                          @ModelAttribute("password")String password,
                          ModelMap modelMap)
    throws NoSuchAlgorithmException {

        if(userService.validateUser(username, password)) {
            modelMap.addAttribute("login", username);
            modelMap.addAttribute("password", password);
            currentId = userService.findUserByLogin(username);
            modelMap.addAttribute("currentId", currentId);

            List<Journey> journeys = journeyService.findUserJourneys(currentId);
            modelMap.addAttribute("journeys", journeys);

            List<Couchsurfer> couchsurfers = couchsurferService.findUserCouchsurfers(currentId);
            modelMap.addAttribute("couchsurfers", couchsurfers);

            List<Transport> transports = transportService.findUserTransports(currentId);
            modelMap.addAttribute("transports", transports);

            List<Expense> expenses = expenseService.findExpenses(currentId);
            modelMap.addAttribute("expenses", expenses);

            List<Member> members = memberService.findMembers(currentId);
            modelMap.addAttribute("members", members);

            return "afterlogin";
        } else {
            if(currentId > 0){
                modelMap.addAttribute("login", username);

                List<Journey> journeys = journeyService.findUserJourneys(currentId);
                modelMap.addAttribute("journeys", journeys);

                List<Couchsurfer> couchsurfers = couchsurferService.findUserCouchsurfers(currentId);
                modelMap.addAttribute("couchsurfers", couchsurfers);

                List<Transport> transports = transportService.findUserTransports(currentId);
                modelMap.addAttribute("transports", transports);

                List<Expense> expenses = expenseService.findExpenses(currentId);
                modelMap.addAttribute("expenses", expenses);

                List<Member> members = memberService.findMembers(currentId);
                modelMap.addAttribute("members", members);

                return "afterlogin";
            } else {
                return "errorlogin";
            }
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registration(@ModelAttribute("reglogin")String username,
                                @ModelAttribute("regpassword")String password,
                                ModelMap modelMap, BindingResult result)
    throws NoSuchAlgorithmException {

        if(!userService.isUsernameUnique(username)){
            User user = new User();
            user.setLogin(username);
            user.setPassword(password);

            userService.addUser(user);

            modelMap.addAttribute("login", username);
            return "regsuccess";
        } else {
            return "errorreg";
        }
    }

    /*
    Journey
     */
    @RequestMapping(value = "/addJourney", method = RequestMethod.GET)
    public String addExcercise(@ModelAttribute("exname")String exname,
                               @ModelAttribute("excountry")String excountry,
                               @ModelAttribute("excost")int excost,
                               @ModelAttribute("exstart_date")Date exstart_date,
                               @ModelAttribute("exend_date")Date exend_date){

        Journey journey = new Journey();
        journey.setName(exname);
        journey.setCountry(excountry);
        journey.setCost(excost);
        journey.setStart_date(exstart_date);
        journey.setEnd_date(exend_date);


        journeyService.addJourney(journey, currentId);
        return "redirect:/afterlogin";
    }

    @RequestMapping(value = "/delete-{id}-journey")
    public String deleteExcercise(@PathVariable int id){
        journeyService.deleteJourney(id);
        return "redirect:/afterlogin";
    }

    /*
    Couchsurfer
     */
    @RequestMapping(value = "/addCouchsurfer", method = RequestMethod.GET)
    public String addMeal(@ModelAttribute("cexname")String cexname,
                          @ModelAttribute("cexsurname")String cexsurname,
                          @ModelAttribute("cexaddress")String cexaddress,
                          @ModelAttribute("cexarrival_date")Date cexarrival_date,
                          @ModelAttribute("cexdeparture_date")Date cexdeparture_date){

        Couchsurfer couchsurfer = new Couchsurfer();
        couchsurfer.setName(cexname);
        couchsurfer.setSurname(cexsurname);
        couchsurfer.setAddress(cexaddress);
        couchsurfer.setArrival_date(cexarrival_date);
        couchsurfer.setDeparture_date(cexdeparture_date);

        couchsurferService.addCouchsurfer(couchsurfer, currentId);
        return "redirect:/afterlogin";
    }

    @RequestMapping(value = "/delete-{id}-couchsurfer")
    public String deleteCouchsurfer(@PathVariable int id){
        couchsurferService.deleteCouchsurfer(id);
        return "redirect:/afterlogin";
    }

    /*
    Transport
     */
    @RequestMapping(value = "/addTransport", method = RequestMethod.GET)
    public String addTransport(@ModelAttribute("texname")String texname,
                               @ModelAttribute("textype")String textype,
                               @ModelAttribute("texwho_buy")Integer texwho_buy,
                               @ModelAttribute("texcost")Integer texcost,
                               @ModelAttribute("texpurchase_date")Date texpurchase_date) {
        Transport transport = new Transport();
        transport.setName(texname);
        transport.setType(textype);
        transport.setMember_id(texwho_buy);
        transport.setCost(texcost);
        transport.setPurchase_date(texpurchase_date);


        transportService.addTransport(transport, currentId);
        return "redirect:/afterlogin";
    }

    @RequestMapping(value = "/delete-{id}-transport")
    public String deleteTransport(@PathVariable int id){
        transportService.deleteTransport(id);
        return "redirect:/afterlogin";
    }

    /*
   Expense
    */
    @RequestMapping(value = "/addExpense", method = RequestMethod.GET)
    public String addExpense(@ModelAttribute("eexname")String eexname,
                                   @ModelAttribute("eexcost")Integer eexcost,
                                   @ModelAttribute("eexmember_id")Integer eexmember_id){
        Expense expense = new Expense();
        expense.setName(eexname);
        expense.setCost(eexcost);
        expense.setMember_id(eexmember_id);
        expenseService.addExpense(expense, currentId);
        return "redirect:/afterlogin";
    }

    @RequestMapping(value = "/delete-{id}-expense")
    public String deleteExpense(@PathVariable int id){
        expenseService.deleteExpense(id);
        return "redirect:/afterlogin";
    }

    /*
   Member
   */
    @RequestMapping(value = "/addMember", method = RequestMethod.GET)
    public String addMember(@ModelAttribute("mexname")String mexname,
                           @ModelAttribute("mexsurname")String mexsurname){
        Member member = new Member();
        member.setName(mexname);
        member.setSurname(mexsurname);

        memberService.addMember(member, currentId);
        return "redirect:/afterlogin";
    }

    @RequestMapping(value = "/delete-{id}-member")
    public String deleteQuote(@PathVariable int id){
        memberService.deleteMember(id);
        return "redirect:/afterlogin";
    }
}
