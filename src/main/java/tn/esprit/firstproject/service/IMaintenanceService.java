package tn.esprit.firstproject.service;

import tn.esprit.firstproject.entities.Maintenance;

import java.util.List;

public interface IMaintenanceService {
    Maintenance addMaintenance(Maintenance maintenance);

    List<Maintenance> retrieveAllMaintenances();

    Maintenance retrieveMaintenance(Long idMaintenance);

    Maintenance updateMaintenance(Maintenance maintenance);

    void removeMaintenance(Long idMaintenance);
}
