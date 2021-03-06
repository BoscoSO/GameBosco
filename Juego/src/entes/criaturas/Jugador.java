package entes.criaturas;

import control.Teclado;
import graficos.Pantalla;
import graficos.Sprite;
import mapa.Mapa;

public class Jugador extends Criatura{
	
	private Teclado teclado;
	
	private int animacion;
	
	public Jugador(Mapa mapa,Teclado teclado,Sprite sprite) {
		this.mapa=mapa;
		this.teclado=teclado;
		this.sprite=sprite;
	}
	
	public Jugador(Mapa mapa,Teclado teclado,Sprite sprite,int posicionX,int posicionY) {
		this.mapa=mapa;
		this.teclado=teclado;
		this.x=posicionX;
		this.y=posicionY;
		this.sprite=sprite;
	}
	
	public void actualizar() {
		
		int desplazamientoX=0;
		int desplazamientoY=0;
		int velocidadMovimiento=1;
		
		if(animacion<32767) {
			animacion++;	
		}else {
			animacion=0;
		}
		if(teclado.correr) {
			velocidadMovimiento=2;
		}
		
		if(teclado.arriba) {
			desplazamientoY-=velocidadMovimiento;
		}	
		if(teclado.abajo) {
			desplazamientoY+=velocidadMovimiento;
		}
		if(teclado.derecha) {
			desplazamientoX+=velocidadMovimiento;
		}
		if(teclado.izquierda) {
			desplazamientoX-=velocidadMovimiento;
		}
		
		if(desplazamientoX != 0 || desplazamientoY != 0) {
			mover(desplazamientoX,desplazamientoY);
			enMovimiento=true;
		}else {
			enMovimiento=false;
		}
		//animaciones movimiento
		if(direccion== 'n') {
			
		}
		if(direccion== 's') {
			
		}
		if(direccion== 'o') {
			int resto=animacion%120;
			
			sprite=Sprite.izquierda0;
			if(enMovimiento) {
				if(resto>15 && resto<=30) {
					sprite=Sprite.izquierda1;
				}else if(resto>30 && resto<=45 ) {
					sprite=Sprite.izquierda2;
				}else if(resto>45 && resto<=60 ) {
					sprite=Sprite.izquierda3;
				}else if(resto>60 && resto<=75 ) {
					sprite=Sprite.izquierda4;
				}else if(resto>75 && resto<=90 ) {
					sprite=Sprite.izquierda5;
				}else if(resto>90 && resto<=105 ) {
					sprite=Sprite.izquierda6;
				}else if(resto>105) {
					sprite=Sprite.izquierda7;
				}
			}
		}
		if(direccion== 'e') {
			int resto=animacion%120;
			sprite=Sprite.derecha0;
			if(enMovimiento) {
				if(resto>15 && resto<=30) {
					sprite=Sprite.derecha1;
				}else if(resto>30 && resto<=45 ) {
					sprite=Sprite.derecha2;
				}else if(resto>45 && resto<=60 ) {
					sprite=Sprite.derecha3;
				}else if(resto>60 && resto<=75 ) {
					sprite=Sprite.derecha4;
				}else if(resto>75 && resto<=90 ) {
					sprite=Sprite.derecha5;
				}else if(resto>90 && resto<=105 ) {
					sprite=Sprite.derecha6;
				}else if(resto>105) {
					sprite=Sprite.derecha7;
				}
			}
		}
		if(!enMovimiento) {
			sprite=Sprite.jugadorFrente;
		}
		

	}
	
	public void mostrar(Pantalla pantalla) {
		pantalla.mostrarJugador(x, y, this);
	}
	
}
