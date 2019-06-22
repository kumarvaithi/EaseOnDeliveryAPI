import React, {Component} from 'react'
import PropTypes from 'prop-types'
import fetchPopularRepos from '../utils/api'
const SelectLanguage =({selectedLanguae,onSelect})=>{
    const langauges = ['ALL','JS','CSS','RUBY','JAVA']
    return(
        <div className="nav-bar">
            <ul >
            {langauges.map((lang) => (
                // <li style = {lang === selectedLanguae ? {color : '#fff'}: null}  
                <li className = {lang === selectedLanguae ? 'active' : null}
                    onClick = {() => onSelect(lang)}
                    key={lang}
                >
                    <a>{lang}</a>
                </li> 
            ))}
        </ul>
        </div>
    )
}

function ReportGrid(props){
    const {repos} = props
    return(
        <div className='course-list'>
            <ul>
                {repos.map(({name,owner,html_url,stargazers_count})=>(
                    <li key = {name}>
                        <ul>
                            <li>
                                <img src={owner.avatar_url} 
                                    alt={'Avator for ' + owner.login}
                                />
                            </li>
                            <li><a href={html_url}>{name}</a></li>
                            <li>@{owner.login}</li>
                            <li>{stargazers_count} starts</li>
                        </ul>
                    </li>
                ))}
            </ul>
        </div>
        
    )
}
SelectLanguage.propTypes = {
    selectedLanguae : PropTypes.string.isRequired,
    onSelect : PropTypes.func.isRequired

}
class P0 extends Component{
    state = {
        selectedLanguae : 'ALL',
        repos : null
    }

    componentDidMount(){
        this.updateLanguage(this.state.selectedLanguae)
    }

    updateLanguage = (lang)=>{
        this.setState(()=>{
            return{
                selectedLanguae : lang,
                repos : null
            }
        });
        fetchPopularRepos(lang)
        .then((repos) =>{
            this.setState(()=>{
                return{
                    repos:repos
                }
            });
        })
    }
    render(){        
        return(
            <div>
                {<SelectLanguage 
                    selectedLanguae = {this.state.selectedLanguae}
                    onSelect = {this.updateLanguage}
                />}
                <br/>
                {!this.state.repos
                ? <p>time taken to load api from git</p>
                :<ReportGrid repos ={this.state.repos}/>}
                
            </div>
        )
        
    }
    
}

export default P0;