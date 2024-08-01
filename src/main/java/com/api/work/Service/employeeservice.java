package com.api.work.Service;

import com.api.work.entities.employee;
import com.api.work.entities.employeeDto;
import com.api.work.repository.Emprepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class employeeservice implements EService {

    @Autowired
    private Emprepo repo;

    List<employee> list;

    public employeeservice(){
//        list = new ArrayList<>();
//        list.add(new employee(1,"Salman","Karachi",24));
//        list.add(new employee(2,"Waleed","Hyderbad",22));
//        list.add(new employee(3,"Aakhiz","Lahore",20));
//        list.add(new employee(4,"Hassan","Quetta",19));


    }
    @Override
    public List<employee> getemployee() {
        return repo.findAll();
    }

     @Override
     public Optional<employee> getEmp(Long empid) {
//            employee e = null;
//          for(employee emp : list)
//              if (emp.getId() == empid) {
//                    e = emp;
//              }

         return repo.findById(empid);
     }

    @Override
    public employeeDto addEmp(employeeDto entity) {
        employee entity1 = convertToEntity(entity);
        employee savedEntity = repo.save(entity1);
        return convertToDto(savedEntity);
    }


    public employee convertToEntity(employeeDto dto) {
        employee entity = new employee();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setAge(dto.getAge());
        return entity;
    }


    public employeeDto convertToDto(employee entity) {
        employeeDto dto = new employeeDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setAge(entity.getAge());
        return dto;
    }

//     @Override
//     public employee addEmp(employeeDTO Emp) {
//         repo.save(Emp);
//         return Emp;
//     }

     @Override
     public employee updateEmp(employee Emp) {
//        list.forEach(e->{
//            if(e.getId()== Emp.getId()){
//                e.setAddress(Emp.getAddress());
//                e.setName(Emp.getName());
//                e.setAge(Emp.getAge());
//            }
//        });
         repo.save(Emp);
        return Emp;
     }

     @Override
     public void deleteemp(long empid) {
//        list = this.list.stream().filter(e->e.getId()!=empid).collect(Collectors.toList());

            repo.deleteById(empid);
     }


 }
