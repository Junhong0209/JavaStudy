package kr.hs.dgsw.java.c2.programming_test.AddressBook;

import java.util.List;

public interface PhoneBook {

	public List<NameCard> getList();
	
	public NameCard getCard(int id);

	public List<NameCard> getCard(String name);
	
	public int addCard(String name, String phoneNumber, String address);
	
	public boolean removeCard(int id);
	
	public void updateCard(int id, String name, String phoneNumber, String address);
	
	public int size();
	
}
