package com.salesianostriana.b2b.formbean;

public class LoginUser {
	
				
		
				private String usuario;
			
				private String pass;
			
				// Constructores
				
				public LoginUser () {
					
				}

				public LoginUser(String usuario, String pass) {
					super();
					this.usuario = usuario;
					this.pass = pass;
				}
				
				//Getters And Setters

				public String getUsuario() {
					return usuario;
				}

				public void setUsuario(String usuario) {
					this.usuario = usuario;
				}

				public String getPass() {
					return pass;
				}

				public void setPass(String pass) {
					this.pass = pass;
				}

				//toString
				@Override
				public String toString() {
					return "LoginAdmin [usuario=" + usuario + ", pass=" + pass + "]";
				}
				
				//HashCode e Equals

				@Override
				public int hashCode() {
					final int prime = 31;
					int result = 1;
					result = prime * result + ((pass == null) ? 0 : pass.hashCode());
					result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
					return result;
				}

				@Override
				public boolean equals(Object obj) {
					if (this == obj)
						return true;
					if (obj == null)
						return false;
					if (getClass() != obj.getClass())
						return false;
					LoginUser other = (LoginUser) obj;
					if (pass == null) {
						if (other.pass != null)
							return false;
					} else if (!pass.equals(other.pass))
						return false;
					if (usuario == null) {
						if (other.usuario != null)
							return false;
					} else if (!usuario.equals(other.usuario))
						return false;
					return true;
				}
	
				
}


