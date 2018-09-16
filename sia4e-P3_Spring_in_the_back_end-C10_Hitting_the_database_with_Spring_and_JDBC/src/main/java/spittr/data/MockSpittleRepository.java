package spittr.data;

import java.util.List;

import org.springframework.stereotype.Repository;

import spittr.Spittle;

@Repository("mockSpittle")
public class MockSpittleRepository implements SpittleRepository {

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Spittle findOne(long spittleId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Spittle spittle) {
        // TODO Auto-generated method stub
        
    }

}
