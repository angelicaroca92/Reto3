package com.usa.misiontic.com.reto3_ciclo3.Servicio;

import com.usa.misiontic.com.reto3_ciclo3.Modelo.Client;
import com.usa.misiontic.com.reto3_ciclo3.Modelo.Reservation;
import com.usa.misiontic.com.reto3_ciclo3.Repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private   ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation r){
        if(r.getIdReservation()==null){
            return reservationRepository.save(r);
        }else{
            Optional<Reservation> re = reservationRepository.getReservation(r.getIdReservation());
            if(re.isPresent()){
                return r;
            }else {
                return reservationRepository.save(r);
            }
        }

    }

    public Reservation Update(Reservation r) {
        if (r.getIdReservation() != null) {
            Optional<Reservation> re = reservationRepository.getReservation(r.getIdReservation());
            if (re.isPresent()){
                if (r.getClient()!=null){
                    re.get().setClient(r.getClient());
                }
                if(r.getStatus()!=null){
                    re.get().setStatus(r.getStatus());
                }
                if(r.getDevolutionDate()!=null){
                    re.get().setDevolutionDate(r.getDevolutionDate());
                }
                if(r.getStartDate()!=null){
                    re.get().setStartDate(r.getStartDate());
                }
                reservationRepository.save(re.get());
                return re.get();
            }else{
                return r;
            }
        } else {
            return r;
        }

    }

}
