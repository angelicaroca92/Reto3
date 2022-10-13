package com.usa.misiontic.com.reto3_ciclo3.Servicio;

import com.usa.misiontic.com.reto3_ciclo3.Modelo.Score;
import com.usa.misiontic.com.reto3_ciclo3.Repositorio.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id) {
        return scoreRepository.getScore(id);
    }

    public Score save(Score score) {
        if (score.getIdScore() == null) {
            return scoreRepository.save(score);
        } else {
            Optional<Score> score1 = scoreRepository.getScore(score.getIdScore());
            if (score1.isPresent()) {
                return score;
            } else {
                return scoreRepository.save(score);
            }

        }

    }
    public Score Update(Score score) {
        if (score.getIdScore() != null) {
            Optional<Score> score1 = scoreRepository.getScore(score.getIdScore());
            if (score1.isPresent()) {
            }
            if (score.getMessageText() != null) {
                score1.get().setMessageText(score.getMessageText());
            }
            if (score.getStars() != null) {
                score1.get().setStars(score.getStars());
            }
            scoreRepository.save(score1.get());
            return score1.get();
        } else {
            return score;
        }

    }

        public boolean delete (int id){
            boolean flag=false;
            Optional<Score> score = scoreRepository.getScore(id);
            if(score.isPresent()){
                scoreRepository.delete(score.get());
                flag=true;
            }
            return flag;
        }
    }










