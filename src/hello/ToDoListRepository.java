package hello;

import java.util.ArrayList;

public class ToDoListRepository {

	public ArrayList<ToDo> findToDoListById(int toDoListId) {

		if (toDoListId == 1) {
			ArrayList<ToDo> toDoList= new ArrayList<>();
			toDoList.add(new ToDo("Apprendre Java"));
			toDoList.add(new ToDo("Apprendre HTML"));
			return toDoList;	
		}else if (toDoListId == 2){
			ArrayList<ToDo> toDoList= new ArrayList<>();
			toDoList.add(new ToDo("Apprendre CSS"));
			toDoList.add(new ToDo("Faire un projet WEB"));
			return toDoList;	
		} else {
			return null;
		}
		
	}
}
