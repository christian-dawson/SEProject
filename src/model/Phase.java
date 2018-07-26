/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Chris
 */
public interface Phase {
    public boolean validateMove(int[] move);
    public void goNext(PhaseHandler p);
}
