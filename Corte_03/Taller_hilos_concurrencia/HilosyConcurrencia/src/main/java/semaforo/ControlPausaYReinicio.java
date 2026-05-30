
package semaforo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import main.Main;


public class ControlPausaYReinicio {
    
    private Lock lock = new ReentrantLock();
    private Condition condicionPausa = lock.newCondition();
    private boolean pausa=true;
    
    public ControlPausaYReinicio(){}
    
    public void verificarEstado(int id) throws InterruptedException{
        lock.lock();
        try {
            while(pausa || id > Main.nodosSecundariosActivos()-1){
                condicionPausa.await();
            }
        } finally {
            lock.unlock();
        }
    }
    
    public void pausar(){
        lock.lock();
        try {
            pausa=true;
        } finally {
            lock.unlock();
        }
    }
    
    public void reanudar(){
        lock.lock();
        try {
            pausa=false;
            condicionPausa.signalAll();
        } finally {
            lock.unlock();
        }
    }
    
    public void notificarNodos(){
        lock.lock();
        try {
            condicionPausa.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
