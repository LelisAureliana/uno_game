/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.game;

import java.util.Stack;
import model.card.Card;
import model.card.CardModel;
import model.player.Player;
import model.user.User;
import model.user.UserModel;

/**
 * Modelo de jogo
 * @author LelaScarlet
 */
public class GameModel {
    private Game actualGame;
    
    private static GameModel myInstaModel;
    private GameModel(){}
    /**
     * Iniciar um novo jogo
     * @param gameMode 
     */
    public void startNewGame(GameMode gameMode){
        actualGame = new Game();
        //Setar o modo de jogo
        actualGame.setGameMode(gameMode);
        
        //Instanciar uma nova pilha de cartas que ja foram jogadas
        actualGame.setStackCardPlayed(new Stack());
        
        //Gerar a pilha de cartas para o jogo
        CardModel cardModel = new CardModel();
        Stack newStack = cardModel.generateCardStack();
        //AQUI CHAMA O METODO DE EMBARALHAR A PILHA PASSANDO ELA COMO PARAMETRO 
        
        //shuffleCards(actualGame.getStackCard());
        
        actualGame.setStackCard(newStack);
        
        //Gerar os players da partida
        Player[] players = generatePlayers();
        actualGame.setPlayers(players);
        
        //Distribui as cartas
        shareCards(players);
    }
    /**
     * Retirar a primeira carta do topo da pilha
     * @return 
     */
    private Card popStackGame(){
        return actualGame.getStackCard().pop();
    }
    
    public Card getHeadStackPlayed(){
        return actualGame.getStackCardPlayed().peek();
    }
    /**
     * Executar a jogada de um player 
     * @param p
     * @param cardPositon 
     */
    public void executeCulp(Player p,int cardPositon){
        
    }
    
    /**
     * Gerar os players para nova partida
     * @return 
     */
    private Player[] generatePlayers() {
        //Primeiro player sempre é o usuario loggado
        Player p1 = new Player(UserModel.USER_LOGGED);
        
        //Gerar Players Sem IA
        //TODO: Futuramente com IA
        User u2 = new User();
        u2.setName("Maquina 1");
        Player p2 = new Player(u2);
        
        User u3 = new User();
        u3.setName("Maquina 2");
        Player p3 = new Player(u3);
        
        User u4 = new User();
        u4.setName("Maquina 3");
        Player p4 = new Player(u4);
        
        return new Player[]{p1,p2,p3,p4};
   
    }

    /***
     * Distribuir as cartas entre os players
     * @param players 
     */
    private void shareCards(Player[] players) {
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < 7; j++) {
                players[i].addCardsOnHand(popStackGame());
            }
        }
    }
    
    public static GameModel myInstance(){
        if(myInstaModel==null){
            myInstaModel = new GameModel();
        }
        return myInstaModel;
    }

    public boolean loadGameSavedFromUser(User user) {
        return false;
    }
}
