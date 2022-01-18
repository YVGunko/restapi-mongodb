package com.stpls.prj;

public enum Level {

	owner ("Владелец"),
	user ("Пользователь"),
	observer ("Наблюдатель");

	   private String title;

	   Level(String title) {
	       this.title = title;
	   }

	   public String getTitle() {
	       return title;
	   }

	   @Override
	   public String toString() {
	       return "Доступ{" +
	               "title='" + title + '\'' +
	               '}';
	   }
}
