package com.example.computer_shop.init;

import com.example.computer_shop.model.Role;
import com.example.computer_shop.model.computer_types.GamingComputer;
import com.example.computer_shop.model.computer_types.HomeComputer;
import com.example.computer_shop.model.computer_types.OfficeComputer;
import com.example.computer_shop.model.cooling_systems.CPUAirCooling;
import com.example.computer_shop.model.cooling_systems.CPUWaterCooling;
import com.example.computer_shop.model.default_components.*;
import com.example.computer_shop.model.drives.FDD;
import com.example.computer_shop.model.drives.HDD;
import com.example.computer_shop.model.drives.SSD;
import com.example.computer_shop.repository.computer_parts.*;
import com.example.computer_shop.service.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final RoleService roleService;
    private final CPURepository cpuRepository;
    private final MotherboardRepository motherboardRepository;
    private final GPURepository gpuRepository;
    private final PowerModuleRepository powerModuleRepository;
    private final RAMRepository ramRepository;
    private final CaseRepository caseRepository;
    private final FDDRepository fddRepository;
    private final SSDRepository ssdRepository;
    private final HDDRepository hddRepository;
    private final CPUWaterCoolingRepository waterCoolingRepository;
    private final CPUAirCoolingRepository airCoolingRepository;
    private final ComputerRepository computerService;

    @PostConstruct
    public void inject() {
        // cpu initialize
        CPU gamingCpu = new CPU("AMD Ryzen 5 5700X", 200);
        CPU homeCpu = new CPU("intel i5", 120);
        CPU officeCpu = new CPU("intel i3", 90);
        cpuRepository.save(gamingCpu);
        cpuRepository.save(homeCpu);
        cpuRepository.save(officeCpu);
        // motherboard initialize
        Motherboard gamingMotherboard = new Motherboard("Gigabyte B550Z Aourus", 120);
        Motherboard homeMotherboard = new Motherboard("Gigabyte B550Z", 100);
        Motherboard officeMotherboard = new Motherboard("Gigabyte B450Z", 80);
        motherboardRepository.save(gamingMotherboard);
        motherboardRepository.save(homeMotherboard);
        motherboardRepository.save(officeMotherboard);
        //Gpu initialize
        GPU gamingGpu = new GPU("Nvidia GTX 3060Ti", (byte) 8,400.99);
        GPU homeGpu = new GPU("Nvidia GTX 1060Ti", (byte) 6,200.99);
        GPU officeGpu = new GPU("Nvidia GTX 940M", (byte) 8,100.99);
        gpuRepository.save(gamingGpu);
        gpuRepository.save(homeGpu);
        gpuRepository.save(officeGpu);
        //Case initialize
        Case gamingCase = new Case("GigantusGaming", "large",300);
        Case homeCase = new Case("FineGaming", "large", 200);
        Case officeCase = new Case("Popusk", "medium", 100);
        caseRepository.save(gamingCase);
        caseRepository.save(homeCase);
        caseRepository.save(officeCase);
        //PowerModule initialize
        PowerModule gamingModule = new PowerModule("Cool", 800,300);
        PowerModule homeModule = new PowerModule("Medium", 600 , 200);
        PowerModule officeModule = new PowerModule("Garbage", 450, 100);
        powerModuleRepository.save(gamingModule);
        powerModuleRepository.save(homeModule);
        powerModuleRepository.save(officeModule);
        //Gpu initialize
        RAM gamingRam = new RAM("Kingston", (byte) 16,150);
        RAM homeRam = new RAM("Kingston", (byte) 8,100);
        RAM officeRam = new RAM("Kingston", (byte) 4,50);
        ramRepository.save(gamingRam);
        ramRepository.save(homeRam);
        ramRepository.save(officeRam);
        //Drive initialize
        SSD ssd  = new SSD("Fast", 150);
        HDD hdd = new HDD("Slow", 75);
        FDD fdd = new FDD(30, "Retus");
        ssdRepository.save(ssd);
        hddRepository.save(hdd);
        fddRepository.save(fdd);
        //cooling initialize
        CPUAirCooling airCooling = new CPUAirCooling((byte) 35, 120, 100);
        CPUWaterCooling waterCooling = new CPUWaterCooling((byte) 15, "gold", 200);
        airCoolingRepository.save(airCooling);
        waterCoolingRepository.save(waterCooling);

        // computer initialize
        GamingComputer gamingComputer = new GamingComputer();
        gamingComputer.setName("UltraGaming PC Lightning");
        gamingComputer.setCpu(gamingCpu);
        gamingComputer.setPowerModule(gamingModule);
        gamingComputer.setMotherboard(gamingMotherboard);
        gamingComputer.setDrive(ssd);
        gamingComputer.setCooling(waterCooling);
        gamingComputer.setComputerCase(gamingCase);
        gamingComputer.setGpu(gamingGpu);
        gamingComputer.setRam(List.of(gamingRam, gamingRam));
        gamingComputer.setPrice(gamingCpu.getPrice()
                + gamingRam.getPrice()*2 + gamingModule.getPrice()
                + gamingGpu.getPrice() + gamingMotherboard.getPrice()
                + gamingCase.getPrice() + waterCooling.getPrice() + ssd.getPrice() + 100);
        computerService.save(gamingComputer);
        HomeComputer homeComputer = new HomeComputer();
        homeComputer.setName("HomeAdvisor PC");
        homeComputer.setCpu(homeCpu);
        homeComputer.setPowerModule(homeModule);
        homeComputer.setMotherboard(homeMotherboard);
        homeComputer.setDrive(ssd);
        homeComputer.setHardDrive(hdd);
        homeComputer.setCooling(airCooling);
        homeComputer.setComputerCase(homeCase);
        homeComputer.setGpu(homeGpu);
        homeComputer.setRam(List.of(homeRam, homeRam));
        homeComputer.setPrice(homeCpu.getPrice()
                + homeRam.getPrice()*2 + homeModule.getPrice()
                + homeGpu.getPrice() + homeMotherboard.getPrice()
                + homeCase.getPrice() + airCooling.getPrice()
                + hdd.getPrice() + ssd.getPrice() + 70);
        computerService.save(homeComputer);
        OfficeComputer officeComputer = new OfficeComputer();
        officeComputer.setName("ForPopusk");
        officeComputer.setCpu(officeCpu);
        officeComputer.setPowerModule(officeModule);
        officeComputer.setMotherboard(officeMotherboard);
        officeComputer.setComputerCase(officeCase);
        officeComputer.setGpu(officeGpu);
        officeComputer.setRam(List.of(officeRam));
        officeComputer.setHardDrive(hdd);
        officeComputer.setFloppyDisk(fdd);
        officeComputer.setPrice(officeCase.getPrice() + officeCpu.getPrice()
                + officeGpu.getPrice() + officeModule.getPrice() + officeRam.getPrice()
                + hdd.getPrice() + fdd.getPrice() + officeMotherboard.getPrice() + 50);
        computerService.save(officeComputer);
        //roles
        Role adminRole = new Role();
        adminRole.setName(Role.RoleName.ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setName(Role.RoleName.USER);
        roleService.add(userRole);
    }
}
