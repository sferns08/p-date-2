package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date (int day, int month, int year) throws DateException {
		//this.month = month;
		this.setMonth(month);
		//this.day = day;
		this.setDay(day);
		//this.year = year;
		this.setYear(year);
	}
	
	public void setDay(int day) throws DateException {
		if ( day < 1 || day > this.getDaysOfMonth() ) {
			throw new DateException("Date error: Day " + day + " of month " + this.month + " not valid");			
		}
		this.day = day;
	}
	
	public void setMonth (int month) throws DateException {
		if ( month < 1 || month > 12) {
			throw new DateException("Date error: Month " + month + " not valid");
		}
		this.month = month;
	}
	
	public void setYear (int year) {
		this.year = year;
	}
	
	private int getDaysOfMonth() {
		int numDays;
		
		numDays = 0;
		switch (this.month) {
		case 1: //next
		case 3: //next
		case 5: //next
		case 7: //next
		case 8: //next
		case 10: //next
		case 12:
			numDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30;
			break;
		case 2:
			numDays = 28;
			break;			
		}
		
		return numDays;
	}
	
	public boolean isSameYear(int year) {
		if(this.year==year) {
			return true;
		}else {
			return false;
		}
	}
	public boolean isSameMonth(int month) {
		if(this.month==month) {
			return true;
		}else {
			return false;
		}
	}
	public boolean isSameDay(int day) {
		if(this.day==day) {
			return true;
		}else {
			return false;
		}
	}
	public boolean isSame(int day, int year, int month) {
		if(this.day==day && this.month==month && this.year==year) {
			return true;
		}else {
			return false;
		}
	}
	public boolean isSameYear2(int year) {
		return this.year==year;
		
	}
	public boolean isSameMonth2(int month) {
		return this.month==month;
	}
	public boolean isSameDay2(int day) {
		return this.day==day;
	}
	public boolean isSame2(int day, int year, int month) {
		return this.day==day && this.month==month && this.year==year;
	}
	private String getNameOfMonth() {
		String nameMonth=null;
		switch (this.month) {
		case 1:
			nameMonth="Enero";
			break;
		case 2: 
			nameMonth="Febrero";
			break;
		case 3: 
			nameMonth="Marzo";
			break;
		case 4: 
			nameMonth="Abril";
			break;
		case 5:
			nameMonth="Mayo";
			break;
		case 6: 
			nameMonth="Junio";
			break;
		case 7:
			nameMonth="Julio";
			break;
		case 8:
			nameMonth="Agosto";
			break;
		case 9:
			nameMonth="Septiembre";
			break;
		case 10:
			nameMonth="Octubre";
			break;
		case 11:
			nameMonth="Noviembre";
			break;
		case 12:
			nameMonth="Diciembre";
			break;
		}
		
		return nameMonth;
	}
	
	public boolean dayIsRight() {
		boolean right=false;
		if(getDaysOfMonth()<this.day || this.day<0) {
			right=false;
		}else {
		right= true;
		}
		return right;
	}
	public String getSeason() {
		String season=null;
		switch (this.month) {
		case 1:
		case 2: 
			season="Invierno";
			break;
		case 3: 
		case 4: 
		case 5:
		case 6: 
			season="Primavera";
			break;
		case 7:
		case 8:
		case 9:
			season="Verano";
			break;
		case 10:
		case 11:
			season="Otoño";
			break;
		case 12:
			season="Invierno";
			break;
		}
		
		return season;
	}
	public int getMonthsUntilYearEnd() {
		return 12-this.month;
	}
	public String stringDate() {
		return this.day + " de " + getNameOfMonth() + " del " + this.year;
	}
	public String getDaysLeftOfMonth(){
		StringBuilder salida = new StringBuilder();

		switch (this.month) {
			case 1://next
			case 3://next
			case 5://next
			case 7://next
			case 8://next
			case 10://next
			case 12:
				for (int i=this.day+1; i<=31 ; ++i ) {
					
					salida.append(i + "/"+ this.month+"/"+this.year);
					
					salida.append(" ");
				}
				break;
			case 2:
				for (int i=this.day+1; i<=28 ; ++i ) {
					
					salida.append(i + "/"+ this.month+"/"+this.year);
					salida.append(" ");
				}
				break;
			case 4://next
			case 6://next
			case 9://next
			case 11:
				for (int i=this.day+1; i<=30 ; ++i ) {
					
					salida.append(i + "/"+ this.month+"/"+this.year);
					salida.append(" ");
				}
				break;
		}
		return salida.toString();
	}
	public String getMonthsSameDays(){

		StringBuilder salida= new StringBuilder();

		switch (this.month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				salida.append("January March May July August October December ");
				break;
			case 2:
				salida.append("February ");
				break;
			case 4: 
			case 6:
			case 9:
			case 11:
				salida.append("April June September November ");
				break;


		}
		return salida.toString();
	}
	public int daysPast(){
	
		int daysFromBegining=0;
	
		for (int i = 1;i<this.month ; i++) {
		 	switch (i) {
		 		case 1://next
				case 3://next
				case 5://next
				case 7://next
				case 8://next
				case 10:
					daysFromBegining += 31;
					break;
				case 2:
					daysFromBegining += 28;
					break;
				case 4://next
				case 6://next
				case 9://next
				case 11:
					daysFromBegining += 30;
					break;
		 	}
		} 
		daysFromBegining += this.day-1;

		return daysFromBegining;
	}
	public int numRandomTriesEqualDate(){	
		//Variables
		int randomDay=365;
		int attempts =0;
		
		while(this.daysPast() != randomDay) {
			randomDay = (int)(Math.random()*((364-0)+1))+0;
			attempts++;
		}
		return attempts;
	}
	public String dayOfWeek(int firstDayOfYear){

		StringBuilder salida = new StringBuilder();
		
		int dayOfWeek = (this.daysPast()%7)+firstDayOfYear;
			//Clasificacion del dia
			switch (dayOfWeek) {
				case 7:
					salida.append("Sunday");
					break;
				case 1:
					salida.append("Monday");
					break;
				case 2:
					salida.append("Tuesday");
					break;
				case 3:	
					salida.append("Wednesday");
					break;
				case 4:
					salida.append("Thursday");
					break;
				case 5:
					salida.append("Friday");
					break;
				case 6:
					salida.append("Saturday");
					break;
			}
		return salida.toString();
	}


	
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

}
