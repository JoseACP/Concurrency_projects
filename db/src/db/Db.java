
package db;

import java.math.BigDecimal;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Db {
    
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    private static String message = "a";
    
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new WriterA());
        t1.setName("Writer A");

        Thread t2 = new Thread(new Update());
        t2.setName("Update");
        

        Thread t3 = new Thread(new Reader());
        t3.setName("Reader");
        
        Thread t4 = new Thread(new Delete());
        t4.setName("Delete");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        
    }
    
    static class Reader implements Runnable {

        public void run() {

            if (lock.isWriteLocked()) {
                System.out.println("Write Lock Present.");
            }
            lock.readLock().lock();

            try {
               Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dbins", "root", "");
            PreparedStatement pst = cn.prepareStatement("select * from alumnos where ID = ?");
            pst.setString(1, "1,2,3");
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
            }
            } catch (SQLException ex) {
                Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                System.out.println(Thread.currentThread().getName() + ": " + message);
                lock.readLock().unlock();
            }
        }
    }

    static class WriterA implements Runnable {

        public void run() {
            lock.writeLock().lock();

            try {
                   Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dbins", "root", "");
            PreparedStatement pst = cn.prepareStatement("insert into alumnos values(?,?,?)");
            
            pst.setString(1, "0");
            pst.setString(2,"Antonio");
            pst.setString(3, "324");
            pst.executeUpdate(); 
            } catch (SQLException ex) {
                Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                message = message.concat("a");
                lock.writeLock().unlock();
            }
        }
    }

    static class Update implements Runnable {

        public void run() {
            lock.writeLock().lock();

            try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dbins", "root", "");
            PreparedStatement pst = cn.prepareStatement("UPDATE alumnos SET NombreAlumno = ?, Grupo = ? WHERE ID = 4");
           
            pst.setString(1, "Amlo");
            pst.setString(2,"909");
            
           
            pst.executeUpdate(); 
            } catch (SQLException ex) {
                Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                message = message.concat("b");
                lock.writeLock().unlock();
            }
        }
    }
    
     static class Delete implements Runnable {

        public void run() {
            lock.writeLock().lock();

            try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dbins", "root", "");
            PreparedStatement pst = cn.prepareStatement("DELETE FROM alumnos WHERE ID = 6");
            
           
            pst.executeUpdate(); 
            } catch (SQLException ex) {
                Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                message = message.concat("b");
                lock.writeLock().unlock();
            }
        }
    }
    
}
