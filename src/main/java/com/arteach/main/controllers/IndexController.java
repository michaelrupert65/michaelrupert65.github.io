package com.arteach.main.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.arteach.main.dao.ICourseRepo;
import com.arteach.main.dao.IMemberRepo;
import com.arteach.main.exceptions.PasswordsDoNotMatchException;
import com.arteach.main.models.Course;
import com.arteach.main.models.Discipline;
import com.arteach.main.models.Event;
import com.arteach.main.models.Facility;
import com.arteach.main.models.Member;
import com.arteach.main.models.Teacher;
import com.arteach.main.services.CourseService;
import com.arteach.main.services.DisciplineService;
import com.arteach.main.services.EventServices;
import com.arteach.main.services.FacilityService;
import com.arteach.main.services.MemberService;
import com.arteach.main.services.TeacherService;

/**
 * @author Michael This is the Controller to handle the mapping for functions to
 *         the HTML elements in the views.
 *
 */

@Controller
public class IndexController {
	@Autowired
	EventServices eventService;
	@Autowired
	MemberService memberService;
	@Autowired
	IMemberRepo memberRepo;
	@Autowired
	DisciplineService disciplineService;
	@Autowired
	TeacherService teacherService;
	@Autowired
	FacilityService facilityService;
	@Autowired
	CourseService courseService;
	@Autowired
	ICourseRepo courseRepo;
	
	// handles mapping to the main index page
	@RequestMapping(value = { "/", "/index" })
	public String index() {
		return "index";
	}

	// Handles Mapping to the successful addition of new member account page
	// when a new member is successfully added to the DB
	@RequestMapping(value = "/newaccountsuccess")
	public String success() {
		return "newaccountsuccess";
	}

	// Mapping to the page the added disciplines to the discipline table
	@GetMapping(value = "/adddiscipline")
	public String discipline(Model model) {
		model.addAttribute("discipline", new Discipline());
		return "adddiscipline";
	}

	// Posts the information to the Teacher table and then
	// displays it to the user if it has been added successfully
	@PostMapping(value = "/addnewdiscipline")
	public String saveDiscipline(@Valid @ModelAttribute Discipline discipline, BindingResult bind) {
		disciplineService.save(discipline);
		return "disciplineadded";
	}
	//Opens the add class page.
	@GetMapping(value = "/addclass")
	public String addclass(Model model) {
		model.addAttribute("course", new Course());
		return "addclass";
	}

	// Posts the information to the Teacher table and then
	// displays it to the user if it has been added successfully
	@PostMapping(value = "/addclass")
	public String saveCourse(@Valid @ModelAttribute("course") Course course,
			@RequestParam(value = "teacherId", required = false) Integer teacherID,
			@RequestParam(value = "disciplineId", required = false) Integer disciplineId, BindingResult bind,
			Model model) {
		model.addAttribute("disipline", disciplineId);// Adds the selection to the model
		model.addAttribute("teacher", teacherID);
		Discipline disc = disciplineService.findById(disciplineId);// Gets the list from the DB
		Teacher teacher = teacherService.findById(teacherID);
		course.getTeacher().add(teacher);
		course.getDiscipline().add(disc);// Adds the selection to the Teacher list for the teacher in question
		model.addAttribute("disc", disc);// adds it to the model
		model.addAttribute("teacher", teacher);
		courseService.save(course);
		
		return "courseAdded";
	}
	//Get add teacher page
	@GetMapping(value = "/addteacher")
	public String teacher(Model model) {
		model.addAttribute("teacher", new Teacher());
		return "addteacher";
	}

	// Posts the information to the Teacher table and then
	// displays it to the user if it has been added successfully
	@PostMapping(value = "/addnewteacher")
	public String saveTeacher(@Valid @ModelAttribute("teacher") Teacher teacher,
			@ModelAttribute("member") Member member,
			@RequestParam(value = "disciplineId", required = false) Integer disciplineId,
			@RequestParam(value = "vPassword") String vPassword, BindingResult bind, Model model) {
		model.addAttribute("disipline", disciplineId);// Adds the selection to the model
		Discipline disc = disciplineService.findById(disciplineId);// Gets the list from the DB
		teacher.getDiscipline().add(disc);// Adds the selection to the Teacher list for the teacher in question
		model.addAttribute("disc", disc);// adds it to the model
		teacher.settRole("TEACHER");
		member.setmFirstName(teacher.getFirstName());
		member.setmLastName(teacher.getLastName());
		member.setmAddress(teacher.gettAddress());
		member.setmCity(teacher.gettCity());
		member.setmState(teacher.gettState());
		member.setmZipCode(teacher.gettZipCode());
		member.setMemberEmail(teacher.getTeacherEmail());
		member.setmCountry(teacher.gettCountry());
		member.setmRegion(teacher.gettRegion());
		member.setmPassword(teacher.gettPassword());
		try {
			if (teacher.gettPassword().equals(vPassword)) {

			} else {
				
				throw new PasswordsDoNotMatchException("Passwords Do Not Match!");
				
			}

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		if(bind.hasErrors())
		{
			return "error";		
		}

		member.setmRole(teacher.gettRole());
		memberService.save(member);
		teacherService.save(teacher);// Persists it to the DB
		return "teacheradded";
	}
	@GetMapping(value="/error")
	public String error(Model model) {
		return "error";
	}

	// Maps to the new account creation page
	@GetMapping(value = "/newaccount")
	public String newUser(Model model) {
		model.addAttribute("member", new Member());
		return "newaccount";
	}

	// Persists a new member to the DB
	@PostMapping(value = "/addnewmember")
	public String saveUser(@Valid @ModelAttribute Member member, @RequestParam(value = "vPassword") String vPassword, BindingResult bind) {
		member.setmRole("USER");
		try {
			if (member.getmPassword().equals(vPassword)) {

			} else {
				
				throw new PasswordsDoNotMatchException("Passwords Do Not Match!");
				
			}

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		if(bind.hasErrors())
		{
			return "error";		
		}
		if(bind.hasErrors())
		{
			
			return "newaccount";		
		}

		memberService.save(member);
		return "newaccountsuccess";
	}


	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/findaclass", method = RequestMethod.GET)
	public String findAClass() {
		return "findaclass";
	}

	@RequestMapping(value = "/searchDB", method = RequestMethod.GET)
	public String searchDB() {
		return "searchDB";
	}

	@RequestMapping(value = "/museum", method = RequestMethod.GET)
	public String museum() {
		return "museum";
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about() {
		return "about";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {
		return "contact";
	}

	// gets the new Event creation page
	@GetMapping("/settings")
	public String settings(Model model) {
		model.addAttribute("settings", new Event());
		return "settings";
	}

	// Persists the New Event information to the DB
	@PostMapping("/settings")
	public String settingsSubmit(@Valid @ModelAttribute Event event, BindingResult bind) {
		eventService.save(event);
		return "submissionsuccess";
	}
	@GetMapping("/editevent")
	public String getEditEvent(Model model) {
		model.addAttribute("event", new Event());
		return "editevent";
	}
	@PostMapping("editevent")
	public String submitEditEvent(@Valid @ModelAttribute Event event, BindingResult bind) {
		
		return "eventeditsuccess";		
	}

	@GetMapping("/addFacility")
	public String facility(Model model) {
		model.addAttribute("facility", new Facility());
		return "addFacility";
	}

	// Persists the New Facility information to the DB
	@PostMapping("/addFacilitySuccess")
	public String facilityAdd(@Valid @ModelAttribute Facility facility, BindingResult bind) {
		facilityService.save(facility);
		return "facilityAddSuccess";
	}


	@RequestMapping(value = "/addrecords", method = RequestMethod.GET)
	public String records() {
		return "addrecords";
	}
	//Builds a list of disciplines
	@ModelAttribute("disciplineList")
	public List<Discipline> getDisciplineList() {
		List<Discipline> disc = disciplineService.findAll();
		return disc;
	}
	//Builds a list of classes
	@ModelAttribute("classList")
	public List<Course> getClassList() {
		List<Course> course = courseService.findAll();
		return course;
	}
	//Builds a list of teachers.
	@ModelAttribute("teacherList")
	public List<Teacher> getTeacherList() {
		List<Teacher> teacher = teacherService.findAll();
		return teacher;
	}
	//Builds a list of events.
	@ModelAttribute("eventList")
	public List<Event> getEventList() {
		List<Event> event = eventService.findAll();
		return event;
	}


	/// Methods to delete info from DB
	@GetMapping("/removeevent")
	public String getDeleteEvent(Model model) {
		model.addAttribute("event", new Event());
		return "removeevent";
	}
	// gets the delete event page
	@GetMapping(value = "/deleteevent")
	public String deleteEvent(@RequestParam("eventId") Integer id, Model model) {

		eventService.deleteById(id);
		model.addAttribute("event", eventService.findAll());
		return "eventdeleted";
	}
	// gets  remove the member page.
	@GetMapping(value = "/removemember")
	public String getRemoveMember(Model model) {
		model.addAttribute("member", new Member());
		return "removemember";
	}
	// remove member from db
	@GetMapping(value = "/deletemember")
	public String deleteMember(@RequestParam("memberEmail") String email, @RequestParam("mFirstName") String fname,
			@RequestParam("mLastName") String lname, Model model) {
		System.out.println("This is the email " + email);
		Optional<Member> mymember = memberRepo.findBymemberEmail(email);
		memberService.deleteById(mymember.get().getMemberId());
		return "deletemember";
	}
	//gets update class
	@GetMapping(value = "/updateclass")
	public String getUpdateClass(Model model) {
		model.addAttribute("course", new Course());
		return "updateclass";
	}

	// Update class descriptions
	@PostMapping(value = "/updateclassinfo")
	public String updateClass(@RequestParam("courseId") Integer cId, @RequestParam("courseDescr") String desc,
			@RequestParam("courseIdSelected") Integer csId, @Valid @ModelAttribute Course course, BindingResult bind,
			Model model) {
		
		Teacher teacher = new Teacher();

		if (cId != null) {
			course = courseService.findById(cId);
		} else {
			course = courseService.findById(csId);
		}
		for(Teacher t : course.getTeacher()) {			
		
			teacher = t;
		}
		course.setCourseDescr(desc);
		courseRepo.save(course);
		model.addAttribute("course", course);
		model.addAttribute("teacher", teacher);

		return "updateclassinfo";
	}
}
