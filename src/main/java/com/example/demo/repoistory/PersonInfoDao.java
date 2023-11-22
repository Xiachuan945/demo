package com.example.demo.repoistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PersonInfo;

@Repository
public interface PersonInfoDao extends JpaRepository<PersonInfo, String> {

	public List<PersonInfo> findByCity(String city) ;
	
	public List<PersonInfo> findByNameAndCity(String name, String city) ;
	
	public List<PersonInfo> findByNameOrCity(String name, String city) ;
	// 4. ��X�~���j���J���󪺩Ҧ��ӤH��T
	public List<PersonInfo> findByAgeGreaterThan(int age) ;
	// 5. �~���p�󵥩��J���󪺩Ҧ��ӤH��T ( �̦~�֥Ѥp��j�Ƨ� ) 
	public List<PersonInfo> findByAgeLessThanEqualOrderByAge(int age) ;
	// 6. �~�֤p���J���� 1�άO�j���J���� 2����T
	public List<PersonInfo> findByAgeLessThanOrAgeGreaterThan(int age1, int age2) ;
	// 7. ���~������ 2 �ӼƦr���� (���]�t) ����T ( �̦~�֥Ѥj��p�Ƨ� - �u���e 3 ����� )
	public List<PersonInfo> findTop3ByAgeBetweenOrderByAgeDesc(int age1, int age2) ; 
	// 8. ���o city �]�t�Y�ӯS�w�r���Ҧ��ӤH��T
	public List<PersonInfo> findByCityContaining(String city) ;
	// 9. �~���j���J���� &  city �]�t�Y�ӯS�w�r���Ҧ��H��T ( �̦~�֥Ѥj��p�Ƨ� )
	public List<PersonInfo> findByAgeGreaterThanAndCityContainingOrderByAgeDesc(int age, String city) ;
}
