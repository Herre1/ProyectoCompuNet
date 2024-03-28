package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Usuario;
import co.edu.icesi.viajes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        List<Usuario> lstUsuario = usuarioRepository.findAll();
        return lstUsuario;
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario save(Usuario entity) throws Exception {
        return usuarioRepository.save(entity);
    }

    @Override
    public Usuario update(Usuario entity) throws Exception {
        return usuarioRepository.save(entity);
    }

    @Override
    public void delete(Usuario entity) throws Exception {
        usuarioRepository.delete(entity);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        usuarioRepository.deleteById(id);
    }

    @Override
    public void validate(Usuario entity) throws Exception {

    }

    @Override
    public Long count() {
        return usuarioRepository.count();
    }
    
    public Usuario crearUsuario(Integer idUsua, String login, String password, String nombre, String identificacion, Date fechaCreacion, String usuCreador, String estado, Integer idRol) {
        Usuario usuario = new Usuario();
        usuario.setIdUsua(idUsua);
        usuario.setLogin(login);
        usuario.setPassword(password);
        usuario.setNombre(nombre);
        usuario.setIdentificacion(identificacion);
        usuario.setFechaCreacion(fechaCreacion);
        usuario.setUsuCreador(usuCreador);
        usuario.setEstado(estado);
        usuario.setIdRol(idRol);

        return usuarioRepository.save(usuario);
    }
  
    
        public Usuario modificarUsuario(Integer idUsua, String login, String password, String nombre, String identificacion, Date fechaCreacion, String usuCreador, String estado, Integer idRol) throws Exception {
            Optional<Usuario> optionalUsuario = usuarioRepository.findById(idUsua);
            if (optionalUsuario.isPresent()) {
                Usuario usuario = optionalUsuario.get();
                usuario.setLogin(login);
                usuario.setPassword(password);
                usuario.setNombre(nombre);
                usuario.setIdentificacion(identificacion);
                usuario.setFechaCreacion(fechaCreacion);
                usuario.setUsuCreador(usuCreador);
                usuario.setEstado(estado);
                usuario.setIdRol(idRol);

                return usuarioRepository.save(usuario);
            } else {
                throw new Exception("Usuario no encontrado");
            }
        }

        
        public void eliminarUsuario(Integer idUsua) throws Exception {
            Optional<Usuario> optionalUsuario = usuarioRepository.findById(idUsua);
            if (optionalUsuario.isPresent()) {
                usuarioRepository.delete(optionalUsuario.get());
            } else {
                throw new Exception("Usuario no encontrado");
            }
        }
    

    
    
    
}
